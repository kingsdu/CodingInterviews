package web_collector;

import org.junit.Test;

public class Crawl_GTZYBTest {

    @Test
    public void visitNews() throws Exception {
        Crawl_GTZYB crawl_gtzyb = new Crawl_GTZYB("crawl",true);
        crawl_gtzyb.start(2);
    }
}