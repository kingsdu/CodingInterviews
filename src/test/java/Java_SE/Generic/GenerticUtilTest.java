package Java_SE.Generic;

import org.junit.Test;

public class GenerticUtilTest {

    @Test
    public void generticTest_1(){
        GenerticUtil<Worker> util = new GenerticUtil<Worker>();
//        util.setObject(new Student());//编译阶段确定错误
    }


    /**
     * 利用泛型 + 接口 显示任何类型
     */
    @Test
    public <E>void generticImple(){
        GenerticImple<E> imple = new GenerticImple();
        imple.show("asdasd");
        imple.show(123);
        imple.show(1.2303);
        imple.show(true);
        imple.show('c');
    }


}