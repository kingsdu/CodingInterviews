package POI;

import org.junit.Test;

public class DocWriteDocTest {

    @Test
    public void write2Docx() throws Exception {
        DocWriteDoc.getInstance().write2Docx();
    }

    @Test
    public void writeTOC() throws Exception {
        DocWriteDoc.getInstance().writeTOC();
    }

    /**
     * 采集系统的新闻的word
     * @throws Exception
     */
    @Test
    public void writeOilWord() throws Exception {
        DocWriteDoc.getInstance().wirteSingleWord();
    }


    /**
     * 带文档类的word
     * @throws Exception
     */
    @Test
    public void writeWordBanchTest() throws Exception {
        DocWriteDoc.getInstance().writeWordBanch();
    }

}