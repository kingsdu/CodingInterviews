package DataStructBook;

import java.util.*;

/**
 * 练习回忆之前学过的代码
 */
public class Practice {

    public static void main(String[] args) {
        System.out.println(fact(5));
    }


    public static int fact(int n){
        if(n == 1){
            return 1;
        }else {
            return n + fact(n-1);
        }
    }

}


