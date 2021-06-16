package DoExercise.MianShiJinDian;

import java.util.Stack;

/**
 * 由两个栈组成的队列
 * 支持队列基本操作（add,poll,peek）
 */
public class TwoStacksQueue {

    private Stack<Integer> stackPush = new Stack<Integer>();
    private Stack<Integer> stackPop = new Stack<Integer>();

    /**
     * 分析
     * <p>
     * 必须满足两个条件
     * 1 stackPush向stackPop中添加元素时，必须一次全部添加进去
     * 2 向stackPop添加时，stackPop必须为空
     */
    public void addQueue(int value) {
        stackPush.push(value);
    }


    public int poll() {
        if (stackPush.empty() && stackPop.empty()) {
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek(){
        if(stackPush.isEmpty() && stackPop.empty()){
            throw new RuntimeException("Queue is empty");
        }else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }


}
