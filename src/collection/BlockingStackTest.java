package collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BlockingStackTest {

    @Test
    void test() {
        MyStack<Integer> integerMyStack = new MyStack<>();
        integerMyStack.push(0);
        integerMyStack.push(1);
        integerMyStack.push(2);
        assertEquals(integerMyStack.size(), 3);

        Integer peek = integerMyStack.peek();
        assertEquals(2, peek);

        Integer pop = integerMyStack.pop();
        assertEquals(2, pop);

        int search = integerMyStack.search(0);
        assertEquals(2, search);

        integerMyStack.pop();
        integerMyStack.pop();
        assertTrue(integerMyStack.empty());
    }
}