package QiyeBishi;

import org.junit.Test;

public class ShunFengTest {

    @Test
    public void reverseNum() {
        System.out.println(ShunFeng.reverseNum(-521));
    }

    /**
     * 后序遍历：CDBFEA
     * 中序遍历：CBDAEF
     */
    @Test
    public void reConsructTree() {
        String[] inStr = new String[]{"CBDAEF"};
        String[] postStr = new String[]{"CDBFEA"};
        ShunFeng.postOrderTraversal(ShunFeng.reConsructTree(inStr, postStr));
    }



    @Test
    public void changeArrayList(){
        int [] array = new int[]{2,3,1};
        for (int i :
                ShunFeng.changeArrayList(array)) {
            System.out.print(i);
        }
    }
}