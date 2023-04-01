# pepScraper

## What is it?:
It's a web scarper that can scrape questions, articles and solutions from pepcoding.com

## Note:
Scraped .mhtml files can be viewed using Microsoft Edge

## How to use pepScraper.js? 
1. Make sure node is installed in your machine. 
2. Clone the repo using  
   > git clone https://github.com/notsanbid/pepScraper.git
3. When inside pepScraper folder, do: 
   > npm install
4. Add your pepcoding account's email ID [here](https://github.com/notsanbid/pepScraper/blob/main/pepScraper.js#L31)
5. Similarly, add password [here](https://github.com/notsanbid/pepScraper/blob/main/pepScraper.js#L35)
6. Provide the url of the 'level' and 'type' of resource you want to scrape 
   > Level 1 URL: https://pepcoding.com/resources/online-java-foundation <br />
   > Level 2 URL: https://pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup <br />
   > Level 3 URL: https://pepcoding.com/resources/data-structures-and-algorithms-in-java-interview-prep <br />
   > To Scrape questions set type to:     `ojquestion` <br />
   > To Scrape articles set type to :     `topic` <br />
   > To Scrape solutions set type to:     `solution` <br />
7. Example, run the following command for downloading Level 1 question
   > node pepScraper.js --url="https://pepcoding.com/resources/online-java-foundation" --type="ojquestion"

## Why is email and password needed?
Repeatedly opening new questions leads to pepcoding.com/login to pop up which screws up the scraping process. Logging in the beginning prevents it.
