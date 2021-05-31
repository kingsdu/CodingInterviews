package DoExercise.HSP_ZCY.A008_Hash;

import java.util.Scanner;


/**
 *
 * 哈希表简易实现
 * 重点
 * 1、构造了链表数组，每个链表节点带有一个数组
 * 2、每次新增和获取元素都需要使用hash函数来寻址
 *
 *
 */
public class HashTabDemo
{
    public static void main(String[] args)
    {
        
        //创建哈希表
        HashTab_HSP hashTab = new HashTab_HSP(7);
        
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");
            
            key = scanner.next();
            switch (key)
            {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp_HSP emp = new Emp_HSP(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
        
    }
}
