package DataStructBook;

/**
 * Stack的使用
 */
public class UseStack {


    public void reverseCharacter(String[] array) {
        StackX stackX = new StackX(array.length);

        for (String i :
                array) {
            stackX.push(i);
        }

        while (!stackX.isEmpty()) {
            System.out.print(stackX.pop());
        }
    }


    /**
     * 匹配括号
     */
    public void bracket(String str) {
        StackX_Char stackX_char = new StackX_Char(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stackX_char.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stackX_char.isEmpty()) {
                        char chx = stackX_char.pop();
                        if ((chx != '{' && ch == '}')
                                || (chx != '[' && ch == ']') ||
                                (chx != '(' && ch == ')')) {
                            System.out.println(ch + " 匹配出现错误,位置" + i);
                        }
                    } else {
                        System.out.println(ch + " 匹配出现错误,位置" + i);
                    }
                    break;
                default:
                    break;
            }
        }
        if (!stackX_char.isEmpty()) {
            System.out.println("整体括号数不匹配");
        }
    }

}
