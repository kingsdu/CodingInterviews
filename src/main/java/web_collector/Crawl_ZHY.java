package web_collector;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.rocks.BreadthCrawler;

/**
 * 抓取中海油新闻网站
 */
public class Crawl_ZHY extends BreadthCrawler {

    public Crawl_ZHY(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        this.addSeed("http://www.cnooc.com.cn/art/2018/8/23/art_191_3038241.html");
        this.addRegex("http://www.cnooc.com.cn/art/201.*.html");
        //http://www.mof.gov.cn/zhengwuxinxi/zhengcefabu/index.htm
    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        System.out.println("visit pages: " + page.url());
    }


    @MatchUrl(urlRegex = "http://www.cnooc.com.cn/art/201.*.html")
    public void visitNews(Page page, CrawlDatums next) {
        String title = null;
        try {
            title = page.select("td[class=title]").first().text();
        }catch (NullPointerException e){
            title = "title";
        }
        System.out.println("URL:\n" + page.url());
    }
}
