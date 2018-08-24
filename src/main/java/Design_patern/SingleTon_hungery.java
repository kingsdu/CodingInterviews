package Design_patern;

/**
 * 单例设计模式，饿汉式
 */
public class SingleTon_hungery {
    private static final SingleTon_hungery singleTon_hungery = new SingleTon_hungery();

    private SingleTon_hungery(){}

    private static SingleTon_hungery getInstance(){
        return singleTon_hungery;
    }
}
