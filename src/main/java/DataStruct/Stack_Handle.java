package DataStruct;


/**
 *
 */
public class Stack_Handle {
    private Stack_Char stack_char;
    private String result = "";

    public Stack_Handle(String str){
        stack_char = new Stack_Char(str.length());
    }

    public static void main(String[] args) {
        String str = "A+B*(C-D)-E*F";
        Stack_Handle stack_handle = new Stack_Handle(str);
        String s = stack_handle.InToPost(str);
        System.out.println(stack_handle.calPostValue(s));
    }

    /**
     * 波兰表达式：基本概念https://blog.csdn.net/linraise/article/details/20459751
     * 中缀：A+B*(C-D)-E*F
     * 后缀：ABCD-*+EF*-
     *
     * 所以：计算机会将中缀表达式转换为后缀表达式，计算后缀表达式的结果
     *
     * 中缀转后缀
     */
    public String InToPost(String str){
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch){
                case '+':
                case '-':
                    push_level(ch,1);
                    break;
                case '*':
                case '/':
                    push_level(ch,2);
                    break;
                case '(':
                    stack_char.push(ch);
                    break;
                case ')':
                    pushParent(ch);
                    break;
                default:
                    result+=ch;
                    break;
            }
        }

        while (!stack_char.isEmpty()){
            result+= stack_char.pop();
        }
        return result;
    }


    /**
     * ) 取出所有的值
     * @param ch
     */
    private void pushParent(char ch) {
        while (!stack_char.isEmpty()){
            char chx = stack_char.pop();
            if(chx == '('){
                break;
            }else {
                result+=chx;
            }
        }
    }


    private void push_level(char ch, int level_1) {
        while (!stack_char.isEmpty()){
            char pop = stack_char.pop();
            if(pop == '('){
                stack_char.push(ch);
                break;
            }else{
                int level_2;
                if(pop == '+' || pop == '-'){
                    level_2 = 1;
                }else {
                    level_2 = 2;
                }

                if(level_2 < level_1){
                    stack_char.push(pop);
                    break;
                }else {
                    result+=pop;
                }
            }
        }
        stack_char.push(ch);
    }


    /**
     * 计算后缀表达式
     *
     * @param str
     * @return
     */
    public int calPostValue(String str){
        Stack_Char stack_char = new Stack_Char(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                stack_char.push(ch);
            }else {
                //表达式有误，无法继续计算
                if (stack_char.size() < 2) {
                    return -1;
                }
                switch (ch) {
                    case '+':
                        int num = (stack_char.pop() - '0') + (stack_char.pop() - '0');
                        stack_char.push((char) (num + '0'));
                        break;
                    case '-':
                        num = (stack_char.pop() - '0') - (stack_char.pop() - '0');
                        stack_char.push((char) (num + '0'));
                        break;
                    case '*':
                        num = (stack_char.pop() - '0') * (stack_char.pop() - '0');
                        this.stack_char.push((char) (num + '0'));
                        break;
                    case '/':
                        num = (stack_char.pop() - '0') / (stack_char.pop() - '0');
                        this.stack_char.push((char) (num + '0'));
                        break;
                }
            }
        }
        return this.stack_char.peek() - '0';
    }


    /**
     * 括号匹配
     */
    public void bracket(String str){
        Stack_Char stack_char = new Stack_Char(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack_char.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!stack_char.isEmpty()){
                        char chx = stack_char.pop();
                        if ((chx != '{' && ch == '}')
                                || (chx != '[' && ch == ']') ||
                                (chx != '(' && ch == ')')) {
                            System.out.println(ch + " 匹配出现错误,位置" + i);
                        }
                    }else {
                            System.out.println(ch + " 匹配出现错误,位置" + i);
                        }
                    break;
                default:
                    break;
            }
        }
        if (!stack_char.isEmpty()) {
            System.out.println("整体括号数不匹配");
        }
    }
}
