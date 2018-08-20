package web_collector;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

public class DemoAnnotatedAutoNewsCrawler extends BreadthCrawler {

    private int count = 0;

    public DemoAnnotatedAutoNewsCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeed("http://www.xinhuanet.com/politics/leaders/xijinping/jjhj.htm");
        this.addRegex("http://www.xinhuanet.com/politics/leaders/201.*.htm");

        setThreads(50);
        getConf().setTopN(100);
    }

    @MatchUrl(urlRegex = "http://www.xinhuanet.com/politics/leaders/201.*.htm")
    public void visitNews(Page page, CrawlDatums next) {
        String title = null;
        try {
            title = page.select("div[class=h-title]").first().text();
        }catch (NullPointerException e){
            title = page.select("div[class=tit]").first().text();
        }
        count++;
        System.out.println("URL:\n" + page.url());
        System.out.println("title:\n" + title);
        System.out.println("count:"+count);
        /*If you want to add urls to crawl,add them to nextLink*/
        /*WebCollector automatically filters links that have been fetched before*/
            /*If autoParse is true and the link you add to nextLinks does not match the
              regex rules,the link will also been filtered.*/
        //next.add("http://xxxxxx.com");
    }

    public void visit(Page page, CrawlDatums crawlDatums) {
        System.out.println("visit pages that don't match any annotation rules: " + page.url());
    }
}
