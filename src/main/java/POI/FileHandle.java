package POI;

import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.OutputStream;
import java.util.ArrayList;

/**
 * 文件处理
 */
public class FileHandle {


    private void write2Docx(ArrayList<News> loadData, OutputStream outputsream)throws Exception{
        XWPFDocument doc = new XWPFDocument();
        WordSetting.getInstance().setDocumentMargin(doc, "1531", "1440", "1531", "1440");//设置页边距
        WordSetting.getInstance().setDocumentGrid(doc);

        //写红头
        WordFile wordFile = null;

        wordFile = new FileRedWordDynamic(doc);

        ((FileRedWordDynamic) wordFile).writeFileHead();

        doc.write(outputsream);
        outputsream.flush();
        outputsream.close();
    }

}
