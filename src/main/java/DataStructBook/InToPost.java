package DataStructBook;

/**
 * 中缀表达式到后缀表达式的转换
 * <p>
 * 后缀表达式的计算
 */
public class InToPost {

    private StackX_Char theStack;
    private String input;
    private String output = "";

    public InToPost(String in) {
        input = in;
        theStack = new StackX_Char(input.length());
    }


    /**
     * 中缀表达式转换为后缀表达式
     */
    public static String calMidToPost(String input) {
        String output;
        InToPost theTrans = new InToPost(input);
        output = theTrans.doTrans();
        return output;
    }


    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!theStack.isEmpty())     // pop remaining opers
        {
            output = output + theStack.pop(); // write to output
        }
        return output;
    }


    /**
     * @param opThis
     * @param prec1
     *
     * 1+2*3+(4+5)*6
     *
     * 1 分两部分存储，一部分是字符串存输出内容，另一部分符号具有优先级，存在栈中。
     * 2 遍历字符串，需要根据运算符的不同，分情况做处理
     * 3 需要根据栈中运算符，判断计算的优先级（重要）
     * 4 结尾处，若栈中还有元素，则需要全部存入到输出中
     */
    public void gotOper(char opThis, int prec1) {                                // got operator from input
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(')            // if it's a '('
            {
                theStack.push(opTop);      // restore '('
                break;
            } else                          // it's an operator
            {
                int prec2;                 // precedence of new op

                if (opTop == '+' || opTop == '-')  // find new op prec
                    prec2 = 1;
                else
                    prec2 = 2;
                if (prec2 < prec1)          // if prec of new op less
                {                       //    than prec of old
                    theStack.push(opTop);   // save newly-popped op
                    break;
                } else                       // prec of new not less
                    output = output + opTop;  // than prec of old
            }
        }
        theStack.push(opThis);           // push new operator
    }


    public void gotParen(char ch) {                             // got right paren from input
        while (!theStack.isEmpty()) {
            char chx = theStack.pop();
            if (chx == '(')           // if popped '('
                break;                  // we're done
            else                       // if popped operator
                output = output + chx;  // output it
        }
    }


    /**
     * 计算后缀表达式的值
     * <p>
     * 从左到右扫描后缀表达式，遇到运算符就把表达式中该运算符前面两个操作数取出并运算，
     * 然后把结果带回后缀表达式
     * //123*+45+6*+
     */
    public static int calPostValue(String str) {
        StackX_Char stackXChar = new StackX_Char(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                stackXChar.push(ch);
            } else {
                if (stackXChar.size() < 2) {
                    return -1;
                }
                switch (ch) {
                    case '+':
                        int num = stackXChar.pop() - '0' + stackXChar.pop() - '0';
                        stackXChar.push((char) (num + '0'));
                        break;
                    case '-':
                        num = stackXChar.pop() - '0' - stackXChar.pop() - '0';
                        stackXChar.push((char) (num + '0'));
                        break;
                    case '*':
                        num = (stackXChar.pop() - '0') * (stackXChar.pop() - '0');
                        stackXChar.push((char) (num + '0'));
                        break;
                    case '/':
                        num = stackXChar.pop() - '0' / stackXChar.pop() - '0';
                        stackXChar.push((char) (num + '0'));
                        break;
                }
            }
        }
        return stackXChar.peek() - '0';
    }



}
