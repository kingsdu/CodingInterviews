package web_collector;

import org.junit.Test;

import static org.junit.Assert.*;

public class DemoAnnotatedManualNewsCrawlerTest {

    @Test
    public void testVisit() throws Exception{
        DemoAnnotatedManualNewsCrawler crawler = new DemoAnnotatedManualNewsCrawler("crawl", false);

        crawler.getConf().setExecuteInterval(5000);

        crawler.getConf().set("title_prefix","PREFIX_");
        crawler.getConf().set("content_length_limit", 20);

        /*start crawl with depth of 4*/
        crawler.start(4);
    }
}