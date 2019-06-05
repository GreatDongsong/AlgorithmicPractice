package collection;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyStackTest {

    @Test
    void testFun() {
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

    @Test
    void testThreadSafe() {
        MyStack<Integer> integerMyStack = new MyStack<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                integerMyStack.push(finalI);
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    if (!integerMyStack.empty()) integerMyStack.pop();
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    if (!integerMyStack.empty()) integerMyStack.peek();
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (true) {
                    if (!integerMyStack.empty()) integerMyStack.search(0);
                }
            }).start();
        }
    }

    @Test
    void testGeneric() {
        new MyStack<>().push(0);
        new MyStack<>().push("0");
        new MyStack<>().push(0.0f);
        new MyStack<>().push(0.0d);
        new MyStack<>().push(true);
        new MyStack<>().push(new Demo());
    }

    class Demo {
    }
}