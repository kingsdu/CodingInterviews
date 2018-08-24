package web_collector;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

/**
 * 抓取国土资源部新闻
 */
public class Crawl_GTZYB extends BreadthCrawler {


    public Crawl_GTZYB(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeed("http://www.mlr.gov.cn/xwdt/jrxw/index_6.htm");
        this.addRegex("http://www.mlr.gov.cn/xwdt/jrxw/201.*.htm");
    }                 //http://www.mlr.gov.cn/xwdt/jrxw/201807/t20180706_2024046.htm

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        System.out.println("visit pages: " + page.url());
    }

    @MatchUrl(urlRegex = "http://www.mlr.gov.cn/xwdt/jrxw/201.*.htm")
    public void visitNews(Page page, CrawlDatums next) {
        String title = null;
        String time = null;
        try {
            title = page.select("td[class=zw_title]").first().text();
            time = page.select("td[class=Gray12]").first().text();
        }catch (NullPointerException e){
            title = page.select("td[class=zw_title]").first().text();
        }
        System.out.println("URL:\n" + page.url());
        System.out.println("title:\n" + title+"---"+time);
    }
}
