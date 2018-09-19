package DataStructBook;

/**
 * 自己实践
 */
public class InToPost_Learn {

    private StackX_Char stackX_char;

    private String result;
    private String input;

    public InToPost_Learn(String str){
        input = str;
        stackX_char = new StackX_Char(str.length());
    }

    /**
     * 1+2*3+(4+5)*6
     *
     * 中缀表达式转后缀表达式
     * @param str
     * @return
     *
     * 1 分两部分存储，一部分是字符串存输出内容，另一部分符号具有优先级，存在栈中。
     * 2 遍历字符串，需要根据运算符的不同，分情况做处理
     * 3 需要根据栈中运算符，判断计算的优先级（重要）
     * 4 结尾处，若栈中还有元素，则需要全部存入到输出中
     */
    public String changeInToPost(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    pushLevel_1(ch,1);
                    break;
                case '*':
                case '/':
                    pushLevel_1(ch,2);
                    break;
                case '(':
                    stackX_char.push(ch);
                    break;
                case ')':
                    pushParent(ch);
                    break;
                default:
                    break;
            }
        }

        while (!stackX_char.isEmpty()){
            result+=stackX_char.pop();
        }
        return result;
    }


    /**
     * ) 取出所有的值
     * @param ch
     */
    private void pushParent(char ch) {
        while (!stackX_char.isEmpty()){
            char chx = stackX_char.pop();
            if(chx == '('){
                break;
            }else {
                result+=chx;
            }
        }
    }


    /**
     * 将运算符添加至栈中
     * @param ch
     * @param level_1
     */
    private void pushLevel_1(char ch, int level_1) {
        while (!stackX_char.isEmpty()){
            char pop = stackX_char.pop();
            if(pop == '('){
                stackX_char.push(ch);
            }else{
                int level_2;
                if(ch == '+' || ch == '-'){
                    level_2 = 1;
                }else {
                    level_2 = 2;
                }

                if(level_1 < level_2){
                    stackX_char.push(ch);
                }else{
                    result+=pop;
                }
            }
        }
        stackX_char.push(ch);
    }


}
