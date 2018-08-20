package POI;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 按长度截取字符串，超过长度的添加省略符，显示缩写
 */
public class HtmlToDoc {

    private static HtmlToDoc htmlInstance = new HtmlToDoc();

    private HtmlToDoc(){}

    public static HtmlToDoc getInstance() {
        return htmlInstance;
    }

    public String abbreviate(String original, int width, String ellipsis) {
        if (original == null || "".equals(original)) {
            return "";
        }
        int byteIndex = 0;
        int charIndex = 0;
        for (; charIndex < original.length(); charIndex++) {
            byteIndex = (int) original.charAt(byteIndex) > 256 ? byteIndex + 2
                    : byteIndex + 1;
            if (byteIndex > width) {
                break;
            }
        }
        if (byteIndex > width) {
            charIndex = charIndex - ellipsis.length() / 2 * 2;
            return original.substring(0, charIndex > 0 ? charIndex : 0)
                    + ellipsis;
        }
        return original.substring(0, charIndex);
    }


    public String htmlToText_time(String inputString) {
        String htmlStr = inputString;
        String textStr = "";
        String replaceComment="<!--.+-->";
        String scriptRegEx = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
        String styleRegEx = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
        String htmlRegEx1 = "<[^>]*>";
        String htmlRegEx2 = "<[^>]*";
        try {
            Pattern commentPattern = Pattern.compile(replaceComment,
                    Pattern.CASE_INSENSITIVE);
            Matcher commentMatcher = commentPattern.matcher(htmlStr);
            htmlStr = commentMatcher.replaceAll("");

            Pattern scriptPattern = Pattern.compile(scriptRegEx,
                    Pattern.CASE_INSENSITIVE);
            Matcher scriptMatcher = scriptPattern.matcher(htmlStr);
            htmlStr = scriptMatcher.replaceAll("");

            Pattern stylePattern = Pattern.compile(styleRegEx,
                    Pattern.CASE_INSENSITIVE);
            Matcher styleMatcher = stylePattern.matcher(htmlStr);
            htmlStr = styleMatcher.replaceAll("");

            Pattern htmlPattern1 = Pattern.compile(htmlRegEx1,
                    Pattern.CASE_INSENSITIVE);
            Matcher htmlMatcher1 = htmlPattern1.matcher(htmlStr);
            htmlStr = htmlMatcher1.replaceAll("");

            Pattern htmlPattern2 = Pattern.compile(htmlRegEx2,
                    Pattern.CASE_INSENSITIVE);
            Matcher htmlMatcher2 = htmlPattern2.matcher(htmlStr);
            htmlStr = htmlMatcher2.replaceAll("");
            textStr = htmlStr;
        } catch (Exception e) {
            System.err.println("->htmlToText(String inputString):"
                    + e.getMessage());
        }
        textStr = textStr.replaceAll("&acute;", "\'");
        textStr = textStr.replaceAll("&quot;", "\"");
        textStr = textStr.replaceAll("&lt;", "<");
        textStr = textStr.replaceAll("&gt;", ">");
        textStr = textStr.replaceAll("&nbsp;", "");
        textStr = textStr.replaceAll("&amp;", "&");
        textStr = textStr.replaceAll("\n", "");
        textStr = textStr.replaceAll("&divide;", "/");//HTML中的除号为"&divide;"，写入word前要转换
        textStr = textStr.replaceAll("&times;", "x");//HTML中的“x”（乘号）为"&times;"，写入word前要转换
        textStr = textStr.replaceAll("&middot;", "·");//HTML中的“·”（如姓名中间的点号）为"&middot;"，写入word前要转换
        return textStr;
    }

    public String[] htmlToText(String inputString) {
        // String inputString1 = inputString.replaceAll("&acute;", "\'");

        String[] str = null;
        String htmlStr = inputString;

        String replaceComment = "<!--.+-->";
        String scriptRegEx = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
        String styleRegEx = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
        String htmlRegEx1 = "<[^>]*>";
        String htmlRegEx2 = "<[^>]*";
        try {

            Pattern commentPattern = Pattern.compile(replaceComment,
                    Pattern.CASE_INSENSITIVE);
            Matcher commentMatcher = commentPattern.matcher(htmlStr);
            htmlStr = commentMatcher.replaceAll("");
            Pattern scriptPattern = Pattern.compile(scriptRegEx,
                    Pattern.CASE_INSENSITIVE);
            Matcher scriptMatcher = scriptPattern.matcher(htmlStr);
            htmlStr = scriptMatcher.replaceAll("");

            Pattern stylePattern = Pattern.compile(styleRegEx,
                    Pattern.CASE_INSENSITIVE);
            Matcher styleMatcher = stylePattern.matcher(htmlStr);
            htmlStr = styleMatcher.replaceAll("");
            // 根据p标签分组
            str = htmlStr.split("<p>");

            for (int n = 0; n < str.length; n++) {
                // 在这里保留<p>标签
                String contentP = str[n].trim();
                if (str[n].length() > 1) {


                    Pattern htmlPattern1 = Pattern.compile(htmlRegEx1,
                            Pattern.CASE_INSENSITIVE);
                    Matcher htmlMatcher1 = htmlPattern1.matcher(contentP);
                    contentP = htmlMatcher1.replaceAll("");
                    Pattern htmlPattern2 = Pattern.compile(htmlRegEx2,
                            Pattern.CASE_INSENSITIVE);
                    Matcher htmlMatcher2 = htmlPattern2.matcher(contentP);
                    contentP = htmlMatcher2.replaceAll("");
                    while (contentP.startsWith("　")) {
                        contentP = contentP.substring(1, contentP.length())
                                .trim();
                    }
                    str[n] = contentP;
                }
            }

            for (int n = 0; n < str.length; n++) {
                str[n] = str[n].replaceAll("&acute;", "\'");
                str[n] = str[n].replaceAll("&quot;", "\"");
                str[n] = str[n].replaceAll("&lt;", "<");
                str[n] = str[n].replaceAll("&gt;", ">");
                str[n] = str[n].replaceAll("&nbsp;", "");
                str[n] = str[n].replaceAll("&amp;", "&");
                str[n] = str[n].replaceAll("\n", "");
                str[n] = str[n].replaceAll("&divide;", "/");// HTML中的除号为"&divide;"，写入word前要转换
                str[n] = str[n].replaceAll("&times;", "x");// HTML中的“x”（乘号）为"&times;"，写入word前要转换
                str[n] = str[n].replaceAll("&middot;", "·");// HTML中的“·”（如姓名中间的点号）为"&middot;"，写入word前要转换
            }

        } catch (Exception e) {
            System.err.println("->htmlToText(String inputString):"
                    + e.getMessage());
        }

        return str;

    }


    /**
     * 给正文添加class等标签，方便前台统一格式
     *
     * @param inputString
     * @return
     */
    public String addPtoContent(String[] inputString) {
        String contentWithP = "";
        if (inputString.length > 0) {
            for (int i = 0; i < inputString.length; i++) {
                if (inputString[i].trim().length() != 0) {
                    contentWithP = contentWithP + "<p class="
                            + "news_paragraph" + ">" + inputString[i] + "</p>";
                }
            }
        }
        contentWithP = "<div class=" + "news_content" + ">" + contentWithP
                + "</div>";
        return contentWithP;

    }
}
