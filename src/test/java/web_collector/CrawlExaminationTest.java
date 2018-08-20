package web_collector;

import org.junit.Test;

import static org.junit.Assert.*;

public class CrawlExaminationTest {

    @Test
    public void datebaseByContentExtractor() throws Exception {
        CrawlExamination crawlExamination = new CrawlExamination();
        Boolean aBoolean = crawlExamination.datebaseByContentExtractor("http://www.xinhuanet.com/politics/leaders/2018-06/10/c_1122964716.htm","习近平会见阿富汗总统加尼");
        if(aBoolean){
            System.out.println("pass");
        }else {
            System.out.println("failed");
        }
    }
}