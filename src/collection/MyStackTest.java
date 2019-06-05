package collection;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyStackTest {
    private boolean run = true;

    /**
     * 测试所有函数功能
     */
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

    /**
     * 测试MyStack是否支持任何元素类型
     */
    @Test
    void testGeneric() {
        new MyStack<>().push(0);
        new MyStack<>().push("0");
        new MyStack<>().push(0.0f);
        new MyStack<>().push(0.0d);
        new MyStack<>().push(true);
        new MyStack<>().push(new Demo());
    }

    private class Demo {
    }

    /**
     * 测试MyStack是否线程安全
     */
    @Test
    void testThreadSafe() {
        MyStack<Integer> integerMyStack = new MyStack<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            startThread(() -> {
                int nextInt = random.nextInt();
                integerMyStack.push(nextInt);
                System.out.println("push: " + nextInt);
            });
            startThread(() -> {
                if (!integerMyStack.empty()) {
                    Integer pop = integerMyStack.pop();
                    System.out.println("pop: " + pop);
                }
            });
            startThread(() -> {
                if (!integerMyStack.empty()) {
                    Integer peek = integerMyStack.peek();
                    System.out.println("peek: " + peek);
                }
            });
            startThread(() -> {
                if (!integerMyStack.empty()) {
                    int nextInt = random.nextInt();
                    int search = integerMyStack.search(nextInt);
                    System.out.println("search: nextInt:" + nextInt + " index:" + search);
                }
            });
        }

        //10s后停止所有线程
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            run = false;
        }
    }

    void startThread(TaskHandler taskHandler) {
        new Thread(() -> {
            while (run) {
   /*             try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }*/
                taskHandler.handleTask();
            }
        }).start();
    }

    interface TaskHandler {
        void handleTask();
    }
}