package DoExercise.HSP_ZCY.A008_Hash;

public class EmpLinkedList_HSP
{
    //头指针，执行第一个Emp,因此我们这个链表的head 是直接指向第一个Emp
    private Emp_HSP head; //默认null
    
    //添加雇员到链表
    //说明
    //1. 假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
    //   因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp_HSP emp) {
        //如果是添加第一个雇员
        if(head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp_HSP curEmp = head;
        while(true) {
            if(curEmp.next == null) {//说明到链表最后
                break;
            }
            curEmp = curEmp.next; //后移
        }
        //退出时直接将emp 加入链表
        curEmp.next = emp;
    }
    
    //遍历链表的雇员信息
    public void list(int no) {
        if(head == null) { //说明链表为空
            System.out.println("第 "+(no+1)+" 链表为空");
            return;
        }
        System.out.print("第 "+(no+1)+" 链表的信息为");
        Emp_HSP curEmp = head; //辅助指针
        while(true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if(curEmp.next == null) {//说明curEmp已经是最后结点
                break;
            }
            curEmp = curEmp.next; //后移，遍历
        }
        System.out.println();
    }
    
    //根据id查找雇员
    //如果查找到，就返回Emp, 如果没有找到，就返回null
    public Emp_HSP findEmpById(int id) {
        //判断链表是否为空
        if(head == null) {
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp_HSP curEmp = head;
        while(true) {
            if(curEmp.id == id) {//找到
                break;//这时curEmp就指向要查找的雇员
            }
            //退出
            if(curEmp.next == null) {//说明遍历当前链表没有找到该雇员
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;//以后
        }
        
        return curEmp;
    }
}
