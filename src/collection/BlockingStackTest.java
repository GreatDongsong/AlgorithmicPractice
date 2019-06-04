package collection;

class BlockingStackTest {

    @org.junit.jupiter.api.Test
    void push() {
        BlockingStack<Integer> integerBlockingStack = new BlockingStack<>();
        double random = Math.random();
//        integerBlockingStack.push()
        assert Integer(0).equals(integerBlockingStack.pop());
    }

    @org.junit.jupiter.api.Test
    void pop() {
    }

    @org.junit.jupiter.api.Test
    void peek() {
    }

    @org.junit.jupiter.api.Test
    void empty() {
    }

    @org.junit.jupiter.api.Test
    void search() {
    }
}