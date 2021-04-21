package DataStruct.HSP.Day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 波兰表达式:前缀表达式:3*(2+5)-9 == -*+2539
 * 逆波兰表达式:后缀表达式:3*(2+5)-9 == 9325+*-
 */
public class PolandNotation
{
    
    public static void main(String[] args)
    {
        List<String> strExpression = new ArrayList<>();
        String exp = "3*3+6*(2*5-2+3)-9-1*2";
        for (int i = 0; i < exp.length(); i++)
        {
            strExpression.add(String.valueOf(exp.charAt(i)));
        }
        List<String> strings = toInfixExpressionList(strExpression);
        int result = calExpression(strings);
        System.out.println(result);
    }
    
    /**
     * 转后缀表达式
     *
     * 思路:看注释
     *
     * @param expression
     * @return
     */
    public static List<String> toInfixExpressionList(List<String> expression)
    {
        Stack<String> oper = new Stack<>();//存符号
        List<String> num = new ArrayList<>();//存最后结果
        
        for (String item :
                expression)
        {
            //数字
            if (item.matches("\\d+"))
            {
                num.add(item);
            } else if (item.equals("("))
            {
                oper.push(item);
            } else if (item.equals(")"))
            {   //括号的处理
                while (!oper.peek().equals("("))
                {//直接将所有的符号入到结果栈
                    num.add(oper.pop());
                }
                oper.pop();//外层括号出栈
            } else // 符号
            {   //当栈内的运算符优先级 >= 新来的运算符的优先级,则将栈内的运算符都存入到结果栈中
                while (oper.size() != 0 && priority(item) <= priority(oper.peek()))
                {
                    num.add(oper.pop());
                }
                oper.push(item);
            }
        }
        
        while (!oper.isEmpty())
        {
            num.add(oper.pop());
        }
        return num;
    }
    
    
    /**
     *
     * 计算后缀表达式
     * 自己写的
     *
     * @param expression
     * @return
     */
    public static int calExpression(List<String> expression){
        Stack<Integer> resStack = new Stack<>();
    
        for (String item :
                expression)
        {
            if (item.matches("\\d+")){
                resStack.push(Integer.valueOf(item));
            }else {
                int num1 = resStack.pop();
                int num2 = resStack.pop();
                String op = item;
                int res = calNum(num1, num2, op);
                resStack.push(res);
            }
        }
        
        return resStack.peek();
    }
    
    
    
    /**
     * 操作符 返回对应优先级
     *
     * @param operation
     * @return
     */
    public static int priority(String operation)
    {
        if (operation.trim().equals("*") || operation.trim().equals("/"))
        {
            return 2;
        } else if (operation.trim().equals("+") || operation.trim().equals("-"))
        {
            return 1;
        } else
        {
            return -1;
        }
    }
    
    
    /**
     *
     * 计算
     *
     * @param num1
     * @param num2
     * @param ope
     * @return
     */
    public static int calNum(int num1,int num2,String ope){
        int result = 0;
        switch (ope){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num2 / num1;
                break;
            default:
                break;
        }
        return result;
    }
    
}
