package web_collector;

import org.junit.Test;

import static org.junit.Assert.*;

public class DemoAnnotatedAutoNewsCrawlerTest {


    @Test
    public void startCrawl() throws Exception{
        DemoAnnotatedAutoNewsCrawler crawler = new DemoAnnotatedAutoNewsCrawler("crawl", true);
        /*start crawl with depth of 4*/
        crawler.start(3);
    }




}