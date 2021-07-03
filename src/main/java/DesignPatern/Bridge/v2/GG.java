package DesignPatern.Bridge.v2;

public class GG {
    public void chase(MM mm) {
        Gift g = new WarmGift();
        give(mm, g);
    }

    public void give(MM mm, Gift g) {

    }


}
