// node pepScraper.js --url="https://pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup" --type="topic"

import minimist from 'minimist';
import puppeteer from 'puppeteer';
import fs from 'fs';
import path from 'path';
import fetch from 'node-fetch';
let args = minimist(process.argv);
let qCnt = 1;

run();
async function run() {
    // start the browser
    let browser = await puppeteer.launch({
        defaultViewport: null,
        args: [
            "--start-maximized"
        ],
        headless: false
    });

    // get a tab
    let pages = await browser.pages();
    let page = pages[0];

    // go to url
    await page.goto("https://pepcoding.com/login");

    // type userid
    await page.waitForSelector("input[name='email']");
    await page.type("input[name='email']", "xyz@gmail.com", { delay: 50 });

    // type password
    await page.waitForSelector("input[name='password']");
    await page.type("input[name='password']", "123", { delay: 50 });

    // click on login3
    await page.waitForSelector("button[type='submit']");
    await page.click("button[type='submit']");
    await page.waitForTimeout(3000);

    await page.goto(args.url);

    await page.waitForSelector("li.collection-item.row.list-item a");
    const sections = await page.evaluate(() => Array.from(document.querySelectorAll("li.collection-item.row.list-item a"), element => element.href.trim()));
    
    await page.waitForSelector("li.collection-item.row.list-item span.no-padding.col.l10.s9.m10.push-s1.no-margin");
    const sectionNames = await page.evaluate(() => Array.from(document.querySelectorAll("li.collection-item.row.list-item span.no-padding.col.l10.s9.m10.push-s1.no-margin"), element => element.textContent.trim()));

    // create folders 
    for (let i = 0; i < sectionNames.length; i++) {
        let dir = i + 1 + ". "+ sectionNames[i];
        fs.mkdirSync(dir, { recursive: true });
    }
    
    // move through all pages
    for (let i = 0; i < sections.length; i++) {
        await handlePage(browser, sections[i], i + 1 + ". "+ sectionNames[i]);
    }

    await page.close();
}

async function handlePage(browser, url, folderName) {
    let npage = await browser.newPage();
    await npage.goto(url);
    let questions;


    try {
        if(args.type === 'ojquestion' || args.type === 'solution' ){
            await npage.waitForSelector("li[resource-type='ojquestion'] a", {timeout: 5000});
            questions = await npage.evaluate(() => Array.from(document.querySelectorAll("li[resource-type='ojquestion'] a"), element => element.href.trim()));
        } else if(args.type === 'topic'){
            await npage.waitForSelector("li[resource-type='topic'] a", {timeout: 5000});
            questions = await npage.evaluate(() => Array.from(document.querySelectorAll("li[resource-type='topic'] a"), element => element.href.trim()));
        }
        for (let i = 0; i < questions.length; i++) {
            if(args.type === 'solution' )
                await handleSolution(browser, questions[i], folderName);
            else 
                await handleQuestion(browser, questions[i], folderName);
        }
    }
    catch(err) {

    }
    
    await npage.close();
}

async function handleQuestion(browser, url, folderName) {
    let npage = await browser.newPage();
    await npage.goto(url);

    //question name
    let qName = url.substring(0, url.lastIndexOf('/'));
    qName = qName.substring(qName.lastIndexOf('/')+1).replace(/[^a-zA-Z0-9-\s]+/g, '');
    let fileName = qCnt+'. '+qName+'.mhtml';
    fileName = path.join(folderName, fileName);
    
    await npage.waitForTimeout(2000);

    const cdp = await npage.target().createCDPSession();
    const { data } = await cdp.send('Page.captureSnapshot', { format: 'mhtml' });
    fs.writeFileSync(fileName, data);

    qCnt++;
    
    await npage.close();
}

async function handleSolution(browser, url, folderName) {
    let npage = await browser.newPage();
    await npage.goto(url);

    //question name
    let qName = url.substring(0, url.lastIndexOf('/'));
    qName = qName.substring(qName.lastIndexOf('/')+1).replace(/[^a-zA-Z0-9-\s]+/g, '');
    let fileName = qCnt+'. '+qName+'.java';
    fileName = path.join(folderName, fileName);

    const element = await npage.$('input[name="resourceId"]');
    const value = await element.evaluate(node => node.value);
    let solutionURL = "https://pepcoding.com/question/solution/"+value;

    
    await npage.goto(solutionURL);
    let response = await npage.$('pre');
    let data = await response.evaluate(node => node.textContent);
    let jso = JSON.parse(JSON.parse(data));
    let java = jso.java.code.trim();
    fs.writeFileSync(fileName, java);
    
    qCnt++;
    
    await npage.close();
}
