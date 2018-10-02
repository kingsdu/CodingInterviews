package DataStruct;

import org.junit.Test;

import static org.junit.Assert.*;

public class OrderArrayTest {

    @Test
    public void insert() {
        OrderArray orderArray =
                new OrderArray(10);

        for (int i = 0; i < 10; i++) {
            orderArray.insert(i);
        }
        orderArray.printArray();
    }

    @Test
    public void delete() {
        OrderArray orderArray =
                new OrderArray(10);

        for (int i = 0; i < 10; i++) {
            orderArray.insert(i);
        }
        orderArray.printArray();

    }

    @Test
    public void find() {
        OrderArray orderArray =
                new OrderArray(10);

        for (int i = 0; i < 10; i++) {
            orderArray.insert(i);
        }


        System.out.println("index is "+orderArray.find(4));
    }
}