package InterviewGoldBook;

import org.junit.Test;

public class HandleStringTest {

    @Test
    public void judgeString() {
        IsDeformation handleString = new IsDeformation();
        String str1 = "123";
        String str2 = "132";
        if(handleString.judgeString(str1,str2)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }


    @Test
    public void quickSort(){
        int [] array = new int[]{2,3,1,2,3,2,1,2,2,3};
        IsDeformation handleString = new IsDeformation();
        handleString.quickSort(array,0,array.length-1);
        for (int i :
                array) {
            System.out.print(i+" ");
        }
    }

    @Test
    public void xiangWuShuo(){
        int [] array = new int[]{2,2,1,2,3,2,1,2,2,3};
        IsDeformation handleString = new IsDeformation();
        handleString.quickSort(array,0,array.length-1);
        handleString.xiangWuShuo(array);
    }
}