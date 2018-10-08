package Java_SE.Inherit;

import org.junit.Test;

import static org.junit.Assert.*;

public class ChildTest {

    @Test
    public void method() {
        Parent p = new Child();
        Child c = (Child) p;
        c.m();
        p.m();
        System.out.println(p.a+""+p.b);
        System.out.println(((Child) p).a+""+((Child) p).b);
        System.out.println(c.a+""+c.b);
        System.out.println(((Parent)c).a+""+((Parent)c).b);
    }

}