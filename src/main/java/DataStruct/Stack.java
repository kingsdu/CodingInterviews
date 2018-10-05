package DataStruct;

public class Stack {

    private int[] stackArray;
    private int maxSize;
    private int top;

    public Stack(int size){
        this.maxSize = size;
        stackArray = new int[size];
        top = -1;
    }


    /**
     * 增
     */
    public boolean push(int value){
        if(top == maxSize){
            return false;
        }
        stackArray[++top] = value;
        return true;
    }


    /**
     * 查看栈顶元素
     * @return
     */
    public int peek(){
        if(stackArray == null){
            return  -1;
        }
        return stackArray[top];
    }


    /**
     * 返回栈顶元素
     * @return
     */
    public int pop(){
        if(stackArray == null){
            return -1;
        }

        int index = stackArray[top];
        stackArray[top] = 0;
        top--;
        return index;
    }


    /**
     * 删除栈顶元素
     * @return
     */
    public boolean deleteTop(){
        if(stackArray == null){
            return false;
        }

        stackArray[top] = 0;
        top--;
        return true;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }



    public void displayStack(){
        if(top == 0){
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

}
