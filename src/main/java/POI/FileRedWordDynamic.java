package POI;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.math.BigInteger;
import java.util.List;

public class FileRedWordDynamic extends WordFile {

    public FileRedWordDynamic(XWPFDocument doc) {
        super(doc);
        this.redTitleString = "油气工作动态与参考";
        this.intervalTime = "2017年第01期（总第165期）";
        this.company = "国土资源部油气资源战略研究中心主办";
    }


    protected void writeIntervalTime() {
        XWPFParagraph headp = doc.createParagraph();
        wordSetting.setParagraphAlignInfo(headp, ParagraphAlignment.CENTER, TextAlignment.CENTER);
        wordSetting.setParagraphSpacingInfo(headp, null, null, "100", null, null, STLineSpacingRule.EXACT);
        wordSetting.setTextFontInfo(headp, false, false, this.intervalTime, "楷体_GB2312", "000000", "36", true, null, false, false, null, 0, null);
    }


    public void writeFileHead() throws Exception {
        writeReadTitle();
        writeIntervalTime();
        writeCompanyAndTime();
        drawRedLine();
    }


    /**
     * 画红线
     * @throws Exception
     * @throws InvalidFormatException
     */
    protected void drawRedLine() throws InvalidFormatException, Exception{
        XWPFParagraph headp = doc.createParagraph();
        wordSetting.setParagraphSpacingInfo(headp, null, null, "100", "200", "400", STLineSpacingRule.EXACT);
        wordSetting.setParagraphAlignInfo(headp, ParagraphAlignment.CENTER, null);
        String imagePath =  this.getClass().getClassLoader().getResource("RedLine.gif").getPath();
        wordSetting.createPicture(imagePath,doc.getNextPicNameNumber(Document.PICTURE_TYPE_PNG), headp);
    }




    /**
     * 写单位和时间
     */
    protected void writeCompanyAndTime(){
        XWPFParagraph headp = doc.createParagraph();
        wordSetting.setParagraphAlignInfo(headp, ParagraphAlignment.CENTER, TextAlignment.CENTER);
        wordSetting.setParagraphSpacingInfo(headp, null, null, "100", null, null, STLineSpacingRule.EXACT);
        wordSetting.setTextFontInfo(headp, false, false, this.company+"\t"+DateConvert.getInstance().getDate(), "华文中宋", "000000", "30",false,null, false, false, null, 0,null);
    }


    /**
     * 写新闻内容
     * @param loadData
     */
    public void writeAllNews(List<News> loadData){
        String[] allText;
        for (int i = 0; i < loadData.size(); i++) {
            writeTitle(loadData.get(i).getTitle(), i);
            allText = HtmlToDoc.getInstance().htmlToText(loadData.get(i).getContent());
            //写正文
            writeContent(allText);
        }
    }


    public void createCustomTOC() {
        CTSdtBlock block = doc.getDocument().getBody().addNewSdt();
        doc.createTOC();
        this.toc = new CustomTOC(block);
        wordSetting.setCustomHeadingStyle(doc, "Heading1", 1);
        wordSetting.setCustomHeadingStyle(doc, "Heading2", 2);
    }



    public void addItem2TOC() {
        List<XWPFParagraph> paragraphs = doc.getParagraphs();
        for (XWPFParagraph par : paragraphs) {
            String parStyle = par.getStyle();
            if (parStyle != null && parStyle.startsWith("Heading")) {
                List<CTBookmark> bookmarkList=par.getCTP().getBookmarkStartList();
                try {
                    int level = Integer.parseInt(parStyle.substring("Heading".length()));
                    if(level==1){
                        //添加栏目
                        toc.addRowOnlyTitle(level, par.getText());
                    }else{
                        //添加标题
                        toc.addRow(level, par.getText(), 1, bookmarkList.get(0).getName());
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    protected void writeTitle(String Title, int bookmarkID) {
        XWPFParagraph p1 = doc.createParagraph();//标题段落
        wordSetting.setParagraphSpacingInfo(p1, null, null, "100", null, null, null);
        wordSetting.setTextFontInfo(p1, false, false, Title, "华文行楷", "000000", "30", true, null, false, false, null, 0, null);
        wordSetting.setParagraphAlignInfo(p1, ParagraphAlignment.CENTER, TextAlignment.BASELINE);//段落居中，文本基线对齐
        //插入书签
        CTBookmark bookStart = p1.getCTP().addNewBookmarkStart();
        bookStart.setName("bookmark" + bookmarkID);
        bookStart.setId(BigInteger.valueOf(bookmarkID));
        CTMarkupRange bookEnd = p1.getCTP().addNewBookmarkEnd();
        bookEnd.setId(BigInteger.valueOf(bookmarkID));
        p1.setStyle("Heading2");
    }


    protected void writeContent(String[] str) {
        for (int j = 0; j < str.length; j++) {//将正文中的每段依次填写在p2中
            if (str[j].trim().length() > 1) {
                if (str[j].trim().codePointAt(0) == 12288) {//识别已有的缩进，缩进为非java表示的空格或制表符，只能通过Ascll识别
                    str[j] = str[j].substring(2);//取消已有的缩进符
                }
                XWPFParagraph p = doc.createParagraph();//正文段落
                wordSetting.setTextFontInfo(p, false, false, str[j].trim(), "宋体", "000000", "21", false, null, false, false, null, 0, null);
                wordSetting.setParagraphIndInfo(p, "440", "200", null, null, null, null, null, null);
                wordSetting.setParagraphAlignInfo(p, ParagraphAlignment.BOTH, TextAlignment.BASELINE);//段落两端对齐，文本基线对齐
                wordSetting.setParagraphSpacingInfo(p, null, null, null, null, "400", STLineSpacingRule.EXACT);
            }
        }
    }


    public void createFooter()throws Exception{
        XWPFHeaderFooterPolicy policy = doc.getHeaderFooterPolicy();
        CTP ctpFooter = CTP.Factory.newInstance();

        XWPFParagraph[] parsFooter;

        CTPPr ctppr = ctpFooter.addNewPPr();
        CTString pst = ctppr.addNewPStyle();
        pst.setVal("style21");
        CTJc ctjc = ctppr.addNewJc();
        ctjc.setVal(STJc.RIGHT);
        ctppr.addNewRPr();

        CTR ctr = ctpFooter.addNewR();
        ctr.addNewRPr();
        CTFldChar fch = ctr.addNewFldChar();
        fch.setFldCharType(STFldCharType.BEGIN);

        ctr = ctpFooter.addNewR();
        ctr.addNewInstrText().setStringValue(" PAGE ");

        ctpFooter.addNewR().addNewFldChar().setFldCharType(STFldCharType.SEPARATE);

        ctpFooter.addNewR().addNewT().setStringValue("1");

        ctpFooter.addNewR().addNewFldChar().setFldCharType(STFldCharType.END);

        XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, doc);

        parsFooter = new XWPFParagraph[1];

        parsFooter[0] = footerParagraph;

        policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);
    }

}
