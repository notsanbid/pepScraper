// node pepScraper.js --url="https://pepcoding.com/resources/online-java-foundation"

let minimist = require("minimist");
let puppeteer = require("puppeteer");
let fs = require("fs");
let path = require("path");
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

    try {
        await npage.waitForSelector("li[resource-type='ojquestion'] a", {timeout: 5000});
        const questions = await npage.evaluate(() => Array.from(document.querySelectorAll("li[resource-type='ojquestion'] a"), element => element.href.trim()));
        
        for (let i = 0; i < questions.length; i++) {
            await handleQuestion(browser, questions[i], folderName);
        }
    
        }   catch (e) {
            
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
    console.log(fileName);
    
    await npage.waitForTimeout(2000);

    const cdp = await npage.target().createCDPSession();
    const { data } = await cdp.send('Page.captureSnapshot', { format: 'mhtml' });
    fs.writeFileSync(fileName, data);

    qCnt++;
    
    await npage.close();
}