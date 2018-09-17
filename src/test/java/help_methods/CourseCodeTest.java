package help_methods;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseCodeTest {

    @Test
    public void calJieChen() {
        CourseCode.calJieChen(5);
    }

    @Test
    public void calBigDataJieChen(){
        CourseCode.calBigDataJieChen(50);
    }
}