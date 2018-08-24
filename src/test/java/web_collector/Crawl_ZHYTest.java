package web_collector;

import org.junit.Test;

import static org.junit.Assert.*;

public class Crawl_ZHYTest {

    @Test
    public void visitNews() throws Exception {
        Crawl_ZHY crawl_zhy = new Crawl_ZHY("crawl",true);
        crawl_zhy.start(4);
    }
}