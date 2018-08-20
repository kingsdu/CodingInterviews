package web_collector;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;

public class DemoAnnotatedManualNewsCrawler extends BreadthCrawler {

    public DemoAnnotatedManualNewsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeedAndReturn("https://blog.github.com/").type("list");
        for(int pageIndex = 2; pageIndex <= 5; pageIndex++) {
            String seedUrl = String.format("https://blog.github.com/page/%d/", pageIndex);
            this.addSeed(seedUrl, "list");
        }

        setThreads(50);
        getConf().setTopN(100);
    }

    public void visit(Page page, CrawlDatums crawlDatums) {
        /*if type is "list"*/
        /*detect content page by css selector and mark their types as "content"*/
        crawlDatums.add(page.links("h1.lh-condensed>a")).type("content");
    }


}
