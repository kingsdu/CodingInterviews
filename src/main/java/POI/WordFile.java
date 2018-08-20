package POI;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TextAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public abstract class WordFile {
    /**
     * word对象
     */
    protected XWPFDocument doc;

    /**
     * word目录（内容列表）
     */
    protected CustomTOC toc;

    /**
     * word格式设置对象
     */
    protected WordSetting wordSetting;

    /**
     * 红头标题说明，如"油气工作动态与参考"
     */
    protected String redTitleString;

    /**
     * 单位信息，如"国土资源部油气资源战略研究中心主办"
     */
    protected String company;

    /**
     * 期号信息，如"2015年第05期（总第145期）"
     */
    protected String intervalTime;

    /**
     * 副标说明，如"——一周热点扫描"
     */
    protected String subTitleString;

    /**
     * 红线下面的文字说明，如"本　周　热　点"
     */
    protected String subRedLineString;

    /**
     * 时间和来源的正则表达式处理器
     */
    protected HtmlToDoc change1;

    public WordFile(XWPFDocument doc) {
        super();
        this.doc = doc;
        this.wordSetting = WordSetting.getInstance();
    }

    /**
     * 写红头标题
     */
    protected void writeReadTitle(){
        XWPFParagraph headp = doc.createParagraph();
        wordSetting.setParagraphAlignInfo(headp, ParagraphAlignment.CENTER, TextAlignment.CENTER);
        wordSetting.setTextFontInfo(headp, false, false, this.redTitleString, "宋体", "ff0000", "90",true,null, false, false, null, 0,null);
    }






}
