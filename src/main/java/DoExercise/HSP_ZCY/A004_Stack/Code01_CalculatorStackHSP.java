package DoExercise.HSP_ZCY.A004_Stack;

/**
 * 栈实现综合计算器
 * <p>
 * 输入:7*2*2-5+1-5+3-4
 * 输出:计算结果
 *
 * 思路：
 * 1、两个栈，一个存数字，一个存符号。
 * 2、遍历字符串。
 * 3、关键逻辑：当符号栈内的符号的 优先级 > 要入栈的符号 ，出栈符号、2个数字，计算数字栈中后2个数字的结果，在存入到数字栈中。
 * 4、字符串遍历完毕后，在逐个对数字和符号栈进行出栈、计算，返回数字栈的最后一个元素。
 *
 */
public class Code01_CalculatorStackHSP
{
    public static Code03_SimpleStackHSP numStack = new Code03_SimpleStackHSP(100);
    public static Code03_SimpleStackHSP opeStack = new Code03_SimpleStackHSP(100);
    
    public static void main(String[] args)
    {
        String expression = "100*100-100+100/100";
        int i = calExpression(expression);
        System.out.println(i);
    }
    
    /**
     * 计算expression
     *
     * @param expression
     * @return
     */
    public static int calExpression(String expression)
    {
        int index = 0;
        char ch = ' ';
        String keepNum = "";//实现多位数控制
        while (index < expression.length())
        {
            ch = expression.substring(index, index + 1).charAt(0);
            if (opeStack.isOper(ch))
            {
                if (!opeStack.isEmpty())
                {
                    //当前的操作符的优先级 <= 栈中的操作符，立马栈中已存在的数据的计算结果
                    if (opeStack.priority(ch) <= opeStack.priority(opeStack.peek()))
                    {
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int oper1 = opeStack.pop();
                        int res = numStack.cal(num1, num2, oper1);
                        numStack.push(res);
                    }
                }
                opeStack.push(ch);
            } else
            {
                keepNum += ch;//考虑多位数问题
                
                if (index == expression.length() - 1)
                {
                    //char -- String -- int 等值转换
                    numStack.push(Integer.parseInt(keepNum));
                } else
                {
                    //判断下一个字符是不是数字，如果是数字，就继续扫描，如果是运算符，则入栈
                    if (opeStack.isOper(expression.substring(index + 1, index + 2).charAt(0)))
                    {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            index++;
        }
        
        //当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号计算
        while (!opeStack.isEmpty()){
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int oper = opeStack.pop();
            int cal = numStack.cal(num1, num2, oper);
            numStack.push(cal);
        }
        
        return numStack.pop();
    }
    
    
}
