package HSP.Day05;

/**
 * 栈实现综合计算器
 * <p>
 * 输入：7*2*2-5+1-5+3-4
 * 计算结果
 */
public class CalculatorStack
{
    public static MyStack numStack = new MyStack(100);
    public static MyStack opeStack = new MyStack(100);
    
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
                if (opeStack.isEmpty())
                {
                    opeStack.push(ch);
                } else
                {
                    //如果当前的操作符的优先级小于或者等于栈中的操作符
                    if(opeStack.priority(ch) <= opeStack.priority(opeStack.peek())){
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int oper1 = opeStack.pop();
                        int res = numStack.cal(num1, num2, oper1);
                        numStack.push(res);
                        opeStack.push(ch);
                    }else {
                        opeStack.push(ch);
                    }
                }
            } else
            {
                keepNum += ch;
                
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
