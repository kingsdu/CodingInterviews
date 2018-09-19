package InterviewGoldBook;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandleStringTest {

    @Test
    public void judgeString() {
        HandleString handleString = new HandleString();
        String str1 = "123";
        String str2 = "132";
        if(handleString.judgeString(str1,str2)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }


    @Test
    public void staticNumTime(){
        HandleString handleString = new HandleString();
        String str = "3364352636333";
        handleString.staticNumTime(str);
    }


    @Test
    public void quickSort(){
        int [] array = new int[]{2,3,1,2,3,2,1,2,2,3};
        HandleString handleString = new HandleString();
        handleString.quickSort(array,0,array.length-1);
        for (int i :
                array) {
            System.out.print(i+" ");
        }
    }

    @Test
    public void xiangWuShuo(){
        int [] array = new int[]{2,2,1,2,3,2,1,2,2,3};
        HandleString handleString = new HandleString();
        handleString.quickSort(array,0,array.length-1);
        handleString.xiangWuShuo(array);
    }
}