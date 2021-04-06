package HSP.Day02;

import java.util.Scanner;


public class Day02
{


    /**
     * 数组实现循环队列
     * @param args
     */
    public static void main(String[] args)
    {
        CircleArrayQueue_mode arrayQueue = new CircleArrayQueue_mode(10);
        Scanner sc = new Scanner(System.in);
        char key = ' ';//用户输入
        boolean flag = true;
        while (flag){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");

            key = sc.next().charAt(0);

            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = sc.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    sc.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    /**
     *
     * 顺序数组实现队列
     *
     * @param args
     */
//    public static void main(String[] args)
//    {
//        ArrayQueue arrayQueue = new ArrayQueue(10);
//        Scanner sc = new Scanner(System.in);
//        char key = ' ';//用户输入
//        boolean flag = true;
//        while (flag){
//            System.out.println("s(show): 显示队列");
//            System.out.println("e(exit): 退出程序");
//            System.out.println("a(add): 添加数据到队列");
//            System.out.println("g(get): 从队列取出数据");
//            System.out.println("h(head): 查看队列头的数据");
//
//            key = sc.next().charAt(0);
//
//            switch (key) {
//                case 's':
//                    arrayQueue.showQueue();
//                    break;
//                case 'a':
//                    System.out.println("输出一个数");
//                    int value = sc.nextInt();
//                    arrayQueue.addQueue(value);
//                    break;
//                case 'g': //取出数据
//                    try {
//                        int res = arrayQueue.getQueue();
//                        System.out.printf("取出的数据是%d\n", res);
//                    } catch (Exception e) {
//                        // TODO: handle exception
//                        System.out.println(e.getMessage());
//                    }
//                    break;
//                case 'e': //退出
//                    sc.close();
//                    flag = false;
//                    break;
//                default:
//                    break;
//            }
//        }
//    }

}
