package web_collector;

import cn.edu.hfut.dmic.contentextractor.News;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.List;

public class Indexdatebase {

    private Document doc;

    private ArrayList<String> listBlackWords = new ArrayList<String>();

    /**
     * 新闻入库
     *
     * @return true 成功 false 失败
     */
    public boolean EnterDateBase(WebCollectorNews newsSelected) throws Exception {
        Indexdatebase indexdatebase = new Indexdatebase();
        CrawlExamination crawlExamination = new CrawlExamination();
        listBlackWords = indexdatebase.getWords("Blacklist");
        if (crawlExamination.check(newsSelected)
                && this.NotContain(newsSelected.getTitle(), listBlackWords)) {
            return true;
        }
        return false;
    }


    // 得到指定节点下的词
    public ArrayList<String> getWords(String Name) throws Exception {
        this.OpenXml("G:\\workspacesql\\Wordsxml.xml");
        ArrayList<String> listWords = new ArrayList<String>();
        Element RootElemtent = doc.getRootElement();
        Element elemtent = RootElemtent.element(Name);

        List<Element> StringElemtents = elemtent.elements();
        for (int i = 0; i < StringElemtents.size(); i++) {
            listWords.add(StringElemtents.get(i).getTextTrim());
        }
        return listWords;

    }

    public void OpenXml(String xml) throws Exception {
        SAXReader sr = new SAXReader();
        sr.setEncoding("UTF-8");

        doc = sr.read(xml);
    }


    // 判断是否不符合词属性
    public boolean NotContain(String Content, ArrayList<String> list) {
        boolean bool = true;
        for (int i = 0; i < list.size(); i++) {
            if (Content.indexOf(list.get(i).toString()) != -1) {
                bool = false;
                break;
            }
        }
        return bool;
    }
}
