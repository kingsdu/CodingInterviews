package OfferDemo;

public class Tujia {

    public static int getMaxNumber(int n1,int n2){
        int maxNumber = 0;
        if(n1 < n2){
            n1 = n1 + n2;
            n2 = n1 - n2;
            n1 = n1 - n2;
        }

        if(n1 % n2 == 0){
            maxNumber = n2;
        }

        while (n1 % n2 > 0){
            n1 = n1 % n2;

            if(n1 < n2){
                n1 = n1 + n2;
                n2 = n1 - n2;
                n1 = n1 - n2;
            }

            if(n1 % n2 == 0){
                maxNumber = n2;
            }
        }
        return maxNumber;
    }

    public static int getMinNumber(int n1,int n2){
        return n1 * n2 / getMaxNumber(n1,n2);
    }


    public static void main(String[] args) {
        int maxNumber = getMaxNumber(15, 9);
        int minNumber = getMinNumber(15, 9);
        System.out.println(maxNumber);
        System.out.println(minNumber);
    }
}
