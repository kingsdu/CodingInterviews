package DataStruct;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    @Test
    public void insert() {
    }

    @Test
    public void remove() {
        Queue queue = new Queue(10);

        for (int i = 1; i <= 10; i++) {
            queue.insert(i);
        }

        queue.dispalyQueue();
    }
}