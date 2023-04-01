# pepScraper

## Note:
Scraped .mhtml files can be viewed using Microsoft Edge

## How to use pepScraper.js? 
1. Make sure node is installed in your machine. 
2. Clone the repo using  
   > git clone https://github.com/notsanbid/pepScraper.git
3. When inside pepScraper folder, do: 
   > npm install
4. Add your pepcoding account's email ID [here](https://github.com/notsanbid/pepScraper/blob/041f436c030f68c075a41c1930e93a69529e2445/pepScraper.js#L30)
5. Similarly, add password [here](https://github.com/notsanbid/pepScraper/blob/041f436c030f68c075a41c1930e93a69529e2445/pepScraper.js#L34)
6. Run the command for downloading Level 1 question
   > node pepScraper.js --url="https://pepcoding.com/resources/online-java-foundation"
7. To download Level 2 or Level 3 change the "--url=" command line argument to "https://pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup" or "https://pepcoding.com/resources/data-structures-and-algorithms-in-java-interview-prep" respectively

## Why do we need to provide email and password?
Repeatedly opening new questions leads to pepcoding.com/login to pop up which screws up the scraping process. Logging in the beginning prevents it.
