package QiyeBishi;

import org.junit.Test;

import java.util.Map;

public class HuaYuKeJiTest {

    @Test
    public void getRank() {
        HuaYuKeJi practice = new HuaYuKeJi();
        int []score = new int[]{4,5,4,2,4};
        int []temp = score.clone();
//        int []temp = Arrays.copyOf(score,score.length);
        Map<Integer, Integer> map = practice.rankingScore(temp);
        practice.getRank(score,map);
    }

    @Test
    public void printPartern() {
        HuaYuKeJi practice = new HuaYuKeJi();
        practice.printPartern(3);
    }
}