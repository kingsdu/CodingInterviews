package QiyeBishi;


import DataStructBook.Node;

/**
 * 小公司面试集锦
 */
public class XiaoGongSi{



    /**
     *
     * 结果：只会返回　3
     * public static void main(String[] args) {
     *         System.out.println(XiaoGongSi.foo());
     *     }
     *
     *     public static int foo(){
     *         try {
     *             return 1;
     *         }catch (Exception e){
     *             return 2;
     *         }finally {
     *             return 3;
     *         }
     *     }
     * */




    /**
     *
     * 输出 pong
     *     ping
     *  public static void main(String[] args) {
     *         Thread t = new Thread(){
     *             @Override
     *             public void run() {
     *                 pong();
     *             }
     *         };
     *         t.run();
     *         System.out.println("ping");
     *     }
     *
     *     static void pong(){
     *         System.out.println("pong");
     *     }
     * */


   /**
    *
    *  输出 good gbc
    *  public static void main(String[] args) {
    *         XiaoGongSi p = new XiaoGongSi();
    *         p.change(p.str,p.ch);
    *         System.out.println(p.str);
    *         System.out.println(p.ch);
    *     }
    *
    *     String str = new String("good");
    *     char[] ch = {'a','b','c'};
    *
    *     public void change(String str,char ch[]){
    *         str = "bad";
    *         ch[0] = 'g';
    *     }
    *     */


   /**
    *
    *  结果：int char long 输出long，其他都为Object
    *  public static void main(String[] args) {
    *         Practice practice = new Practice();
    *         int a = 123;
    *         char b = '1';
    *         long c = 123;
    *         practice.method(c);
    *     }
    *
    *     public void method(long i){
    *         System.out.println("long");
    *     }
    *
    *     public void method(Object i){
    *         System.out.println("Object");
    *     }
    * */




   static int id = 1;

    /**
     * 深圳有为笔试，判断链表是否有环，求出链表的头位置和长度
     * @param head
     * @return
     */
    public Node EnteyNodeOfLoop(Node head){
        Node fast = head;
        Node slow = head;

        while (fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                int len = 1;
                fast = fast.next.next;
                slow = slow.next;
                while (fast != slow){
                    len++;
                    fast = fast.next.next;
                    slow = slow.next;
                }
            }

            fast = head;
            while (fast != slow){
                fast = fast.next;
                slow = slow.next;
                id++;
            }
            return slow;
        }
        return null;
    }

}
