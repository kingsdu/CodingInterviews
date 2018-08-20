package POI;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlToken;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing.CTInline;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;

public class WordSetting {

    private static WordSetting wordSetting = new WordSetting();

    private WordSetting(){

    }

    public static WordSetting getInstance(){
        return wordSetting;
    }


    /**
     *  设置页边距 (word中1厘米约等于567) ，要求上下2.54cm，左右2.7cm,左右默认为3.17
     */
    public void setDocumentMargin(XWPFDocument document, String left, String top, String right, String bottom) {
        CTSectPr sectPr = getDocumentCTSectPr(document);
        CTPageMar ctpagemar = sectPr.addNewPgMar();
        if (StringUtils.isNotBlank(left)) {
            ctpagemar.setLeft(new BigInteger(left));
        }
        if (StringUtils.isNotBlank(top)) {
            ctpagemar.setTop(new BigInteger(top));
        }
        if (StringUtils.isNotBlank(right)) {
            ctpagemar.setRight(new BigInteger(right));
        }
        if (StringUtils.isNotBlank(bottom)) {
            ctpagemar.setBottom(new BigInteger(bottom));
        }

    }


    public void setDocumentGrid(XWPFDocument document){
        CTSectPr sectPr = getDocumentCTSectPr(document);
        CTDocGrid docGrid = sectPr.addNewDocGrid();
        docGrid.setType(STDocGrid.LINES);//接口无效
        docGrid.setLinePitch(BigInteger.valueOf(120));
    }


    public CTSectPr getDocumentCTSectPr(XWPFDocument document) {
        CTSectPr sectPr = document.getDocument().getBody().isSetSectPr() ? document
                .getDocument().getBody().getSectPr()
                : document.getDocument().getBody().addNewSectPr();
        return sectPr;
    }



    /**
     * 设置段落对齐
     */
    public void setParagraphAlignInfo(XWPFParagraph p, ParagraphAlignment pAlign, TextAlignment valign) {
        if(pAlign!=null){
            p.setAlignment(pAlign);
        }
        if(valign!=null){
            p.setVerticalAlignment(valign);
        }
    }



    /**
     * 设置字体以及字体样式
     */
    public void setTextFontInfo(XWPFParagraph p, boolean isInsert,boolean isNewLine, String content, String fontFamily,
                                String colorVal, String fontSize, boolean isBlod,UnderlinePatterns underPatterns, boolean isItalic,
                                boolean isStrike, VerticalAlign verticalAlign, int position,String spacingValue) {
        XWPFRun pRun = null;
        if (isInsert) {
            pRun = p.createRun();
        } else {
            if (p.getRuns() != null && p.getRuns().size() > 0) {
                pRun = p.getRuns().get(0);
            } else {
                pRun = p.createRun();
            }
        }
        if (isNewLine) {
            pRun.addBreak();
        }
        pRun.setText(content);
        // 设置字体样式
        pRun.setBold(isBlod);
        pRun.setItalic(isItalic);
        pRun.setStrike(isStrike);
        if (underPatterns != null) {
            pRun.setUnderline(underPatterns);
        }
        pRun.setColor(colorVal);
        if (verticalAlign != null) {
            pRun.setSubscript(verticalAlign);
        }
        pRun.setTextPosition(position);

        CTRPr pRpr = null;
        if (pRun.getCTR() != null) {
            pRpr = pRun.getCTR().getRPr();
            if (pRpr == null) {
                pRpr = pRun.getCTR().addNewRPr();
            }
        } else {
            // pRpr = p.getCTP().addNewR().addNewRPr();
        }
        // 设置字体
        CTFonts fonts = pRpr.isSetRFonts() ? pRpr.getRFonts() : pRpr
                .addNewRFonts();
        fonts.setAscii("Times New Roman");
        fonts.setEastAsia(fontFamily);
        fonts.setHAnsi(fontFamily);

        // 设置字体大小
        CTHpsMeasure sz = pRpr.isSetSz() ? pRpr.getSz() : pRpr.addNewSz();
        sz.setVal(new BigInteger(fontSize));

        CTHpsMeasure szCs = pRpr.isSetSzCs() ? pRpr.getSzCs() : pRpr
                .addNewSzCs();
        szCs.setVal(new BigInteger(fontSize));

        if(spacingValue!=null){
            //设置字符间距信息
            //CTSignedTwipsMeasure ctSTwipsMeasure=pRpr.isSetSpacing()?pRpr.getSpacing(): pRpr.addNewSpacing();
            //ctSTwipsMeasure.setVal(new BigInteger(spacingValue));
        }
    }


    /**
     * 段落样式控制器
     * @param p
     * @return
     */
    public CTPPr getParagraphCTPPr(XWPFParagraph p) {
        CTPPr pPPr = null;
        if (p.getCTP() != null) {
            if (p.getCTP().getPPr() != null) {
                pPPr = p.getCTP().getPPr();
            } else {
                pPPr = p.getCTP().addNewPPr();
            }
        }
        return pPPr;
    }


    /**
     * 设置段落缩进
     */
    public void setParagraphIndInfo(XWPFParagraph p, String firstLine,
                                    String firstLineChar, String hanging, String hangingChar,
                                    String right, String rigthChar, String left, String leftChar) {
        CTPPr pPPr = getParagraphCTPPr(p);
        CTInd pInd = pPPr.getInd() != null ? pPPr.getInd() : pPPr.addNewInd();
        if (firstLine != null) {
            pInd.setFirstLine(new BigInteger(firstLine));
        }
        if (firstLineChar != null) {
            pInd.setFirstLineChars(new BigInteger(firstLineChar));
        }
        if (hanging != null) {
            pInd.setHanging(new BigInteger(hanging));
        }
        if (hangingChar != null) {
            pInd.setHangingChars(new BigInteger(hangingChar));
        }
        if (left != null) {
            pInd.setLeft(new BigInteger(left));
        }
        if (leftChar != null) {
            pInd.setLeftChars(new BigInteger(leftChar));
        }
        if (right != null) {
            pInd.setRight(new BigInteger(right));
        }
        if (rigthChar != null) {
            pInd.setRightChars(new BigInteger(rigthChar));
        }
    }


    /**
     * 设置段落间距信息,一行=240 一磅=20
     * @param p
     * @param before 段前磅数
     * @param after 段后磅数
     * @param beforeLines 段前行数
     * @param afterLines 段后行数
     * @param line 行间距
     * @param lineValue 行距类型，如最小值(STLineSpacingRule.AT_LEAST)，固定值(STLineSpacingRule.EXACT),
     * 多倍(STLineSpacingRule.AUTO),word中的单倍、1.5倍、2倍行距均选多倍，由line参数计算转换
     */
    public void setParagraphSpacingInfo(XWPFParagraph p, String before,
                                        String after, String beforeLines, String afterLines,
                                        String line, STLineSpacingRule.Enum lineValue) {
        CTPPr pPPr = getParagraphCTPPr(p);
        CTSpacing pSpacing = pPPr.getSpacing() != null ? pPPr.getSpacing(): pPPr.addNewSpacing();
        if (before != null) {
            pSpacing.setBefore(new BigInteger(before));
        }
        if (after != null) {
            pSpacing.setAfter(new BigInteger(after));
        }
        if (beforeLines != null) {
            pSpacing.setBeforeLines(new BigInteger(beforeLines));
        }
        if (afterLines != null) {
            pSpacing.setAfterLines(new BigInteger(afterLines));
        }
        if (line != null) {
            pSpacing.setLine(new BigInteger(line));
        }
        if (lineValue != null) {
            pSpacing.setLineRule(lineValue);
        }
    }



    /**
     * 设置标题样式
     */
    public void setCustomHeadingStyle(XWPFDocument document, String strStyleId, int headingLevel) {

        CTStyle ctStyle = CTStyle.Factory.newInstance();
        ctStyle.setStyleId(strStyleId);

        CTString styleName = CTString.Factory.newInstance();
        styleName.setVal(strStyleId);
        ctStyle.setName(styleName);

        CTDecimalNumber indentNumber = CTDecimalNumber.Factory.newInstance();
        indentNumber.setVal(BigInteger.valueOf(headingLevel));

        // lower number > style is more prominent in the formats bar
        ctStyle.setUiPriority(indentNumber);

        CTOnOff onoffnull = CTOnOff.Factory.newInstance();
        ctStyle.setUnhideWhenUsed(onoffnull);

        // style shows up in the formats bar
        ctStyle.setQFormat(onoffnull);

        // style defines a heading of the given level
        CTPPr ppr = CTPPr.Factory.newInstance();
        ppr.setOutlineLvl(indentNumber);
        ctStyle.setPPr(ppr);

        XWPFStyle style = new XWPFStyle(ctStyle);

        // is a null op if already defined
        XWPFStyles styles = document.createStyles();

        style.setType(STStyleType.PARAGRAPH);
        styles.addStyle(style);

    }


    /**
     * 画红头线
     * @param imagePath
     * @param id
     * @param paragraph
     * @throws Exception
     */
    public void createPicture(String imagePath, int id, XWPFParagraph paragraph) throws Exception {
        String blipId = paragraph.getDocument().addPictureData(new FileInputStream(new File(imagePath)),Document.PICTURE_TYPE_GIF);
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        final int EMU = 9525;
        width *= EMU;
        height *= EMU;
        CTInline inline = paragraph.createRun().getCTR().addNewDrawing().addNewInline();
        String picXml = ""
                + "<a:graphic xmlns:a=\"http://schemas.openxmlformats.org/drawingml/2006/main\">"
                + "   <a:graphicData uri=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">"
                + "      <pic:pic xmlns:pic=\"http://schemas.openxmlformats.org/drawingml/2006/picture\">"
                + "         <pic:nvPicPr>" + "            <pic:cNvPr id=\""
                + id
                + "\" name=\"img_"
                + id
                + "\"/>"
                + "            <pic:cNvPicPr/>"
                + "         </pic:nvPicPr>"
                + "         <pic:blipFill>"
                + "            <a:blip r:embed=\""
                + blipId
                + "\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\"/>"
                + "            <a:stretch>"
                + "               <a:fillRect/>"
                + "            </a:stretch>"
                + "         </pic:blipFill>"
                + "         <pic:spPr>"
                + "            <a:xfrm>"
                + "               <a:off x=\"0\" y=\"0\"/>"
                + "               <a:ext cx=\""
                + width
                + "\" cy=\""
                + height
                + "\"/>"
                + "            </a:xfrm>"
                + "            <a:prstGeom prst=\"rect\">"
                + "               <a:avLst/>"
                + "            </a:prstGeom>"
                + "         </pic:spPr>"
                + "      </pic:pic>"
                + "   </a:graphicData>" + "</a:graphic>";
        // CTGraphicalObjectData graphicData =
        // inline.addNewGraphic().addNewGraphicData();
        XmlToken xmlToken = null;
        try {
            xmlToken = XmlToken.Factory.parse(picXml);
        } catch (XmlException xe) {
            xe.printStackTrace();
        }
        inline.set(xmlToken);
        // graphicData.set(xmlToken);
        inline.setDistT(0);
        inline.setDistB(0);
        inline.setDistL(0);
        inline.setDistR(0);
        CTPositiveSize2D extent = inline.addNewExtent();
        extent.setCx(width);
        extent.setCy(height);
        CTNonVisualDrawingProps docPr = inline.addNewDocPr();
        docPr.setId(id);
        docPr.setName("docx_img_ " + id);
        docPr.setDescr("docx Picture");
    }




}
