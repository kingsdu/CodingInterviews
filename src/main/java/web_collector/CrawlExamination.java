package web_collector;

import cn.edu.hfut.dmic.contentextractor.ContentExtractor;
import cn.edu.hfut.dmic.contentextractor.News;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试爬虫是否漏抓
 */
public class CrawlExamination {

    int intStartTime = Integer.valueOf("2017-03-31".replaceAll("-", ""));

    int intEndTime = Integer.valueOf("2018-10-31".replaceAll("-", ""));


    public Boolean datebaseByContentExtractor(String url,String title) throws Exception {
        News news = ContentExtractor.getNewsByUrl(url);
        if (getNewsTimeCheck(GetTimeA(news.getTime()))) {
            WebCollectorNews webCollectorNews = new WebCollectorNews();
            if (title.equals("")) {
                webCollectorNews.setTitle(news.getTitle());
            } else {
                webCollectorNews.setTitle(title);
            }

            webCollectorNews.setUrl(new String(news.getUrl()
                    .getBytes("iso-8859-1"), "utf-8"));

            String[] contents = HtmlToDoc2.htmlToText(news
                    .getContentElement().toString());
            webCollectorNews.setContentWithP(HtmlToDoc2
                    .addPtoContent(contents));

            webCollectorNews.setHtml(news.getContentElement()
                    .toString());
            webCollectorNews.setMK("12");
            webCollectorNews.setTime(GetTimeA(news.getTime()));

            webCollectorNews.setSiteSource("新华网");
            webCollectorNews.setSource("新华社");

            webCollectorNews.setUrl(news.getUrl());
            webCollectorNews.setContent(news.getContentElement()
                    .toString());

            Indexdatebase indexdatebase = new Indexdatebase();
            if (indexdatebase.EnterDateBase(webCollectorNews)) {
                System.out.println("入库与索引建立成功");
            }

            return true;
        }
        return false;
    }


    public boolean getNewsTimeCheck(String strTime) {

        String NewsTime = strTime.replaceAll("-", "");
        int intNewsTime = Integer.valueOf(NewsTime);
        if (intNewsTime >= intStartTime && intNewsTime <= intEndTime)
            return true;
        return false;
    }


    /**
     * 清洗时间的方法A
     *
     * @param strTime
     *            ContentExtractor清洗出的原始时间
     * @return
     */
    public String GetTimeA(String strTime) {

        Pattern pattern1 = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Pattern pattern2 = Pattern.compile("\\d{4}年\\d{1,2}月\\d{1,2}日");
        Matcher match1 = pattern1.matcher(strTime);
        Matcher match2 = pattern2.matcher(strTime);
        if (match1.find()) {
            strTime = match1.group(0);
        }
        if (match2.find()) {
            strTime = match2.group(0);
            strTime = strTime.replaceAll("[年|月]", "-");
            strTime = strTime.replaceAll("[日]", "");

        }

        if (strTime.length() != 10) {
            if (strTime.charAt(6) == '-') {
                strTime = strTime.substring(0, 5) + '0' + strTime.substring(5);
            }
            if (strTime.length() != 10) {
                strTime = strTime.substring(0, 8) + '0' + strTime.substring(8);
            }
        }

        return strTime;
    }



    public boolean check(WebCollectorNews news){

        boolean bool=true;

        //筛选时间
        if(news.getTime().length()!=10){
            bool=false;
        }

        //筛选标题
        if(news.getTitle().length()<5||news.getTitle().indexOf("购物网站推荐")!=-1||news.getTitle().indexOf("拒绝访问")!=-1||news.getTitle().indexOf("页面没有找的")!=-1){
            bool=false;
        }

        //筛选正文
        if(news.getContent().isEmpty()||news.getContent().length()<=15){
            bool=false;
        }

        //筛选原始来源
        if(news.getSource().length()<3){
            bool=false;
        }

        //筛选网站来源
        if(news.getSiteSource().length()<3){
            bool=false;
        }

        return bool;
    }
}
