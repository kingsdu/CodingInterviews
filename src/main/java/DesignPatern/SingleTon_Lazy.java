package DesignPatern;

/**
 * 懒汉式
 * 特点在于延时加载
 * 可以加同步锁
 * 同步代码块，用双重判断提高效率
 */
public class SingleTon_Lazy {

    private static SingleTon_Lazy singleTon_lazy = null;

    private SingleTon_Lazy(){}

    private static SingleTon_Lazy getInstance(){
        if(singleTon_lazy == null){
            synchronized (SingleTon_Lazy.class){
                if(singleTon_lazy == null){
                    singleTon_lazy = new SingleTon_Lazy();
                }
            }
        }
        return singleTon_lazy;
    }

}
