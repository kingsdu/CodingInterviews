package DataStruct;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeneralArrayTest {

    @Test
    public void insert() {
    }

    @Test
    public void delete() {
        GeneralArray generalArray =
                new GeneralArray(10);
        for (int i = 0; i < 10; i++) {
            generalArray.insert(i);
        }
        generalArray.deleteVal(7);
        generalArray.printArray();
    }



}