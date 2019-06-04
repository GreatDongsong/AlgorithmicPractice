package collection;

import java.util.Arrays;
import java.util.EmptyStackException;

public class BlockingStack<E> {
    private E[] elementArray;
    private int elementCount;
    private int capacityIncrement;

    public BlockingStack() {
    }

    public synchronized E push(E item) {
        ensureCapacity(elementCount + 1);
        elementArray[elementCount++] = item;
        return item;
    }

    public synchronized E pop() {
        E obj = peek();

        int index = size() - 1;
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " +
                    elementCount);
        } else if (index < 0) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        int j = elementCount - index - 1;
        if (j > 0) {
            System.arraycopy(elementArray, index + 1, elementArray, index, j);
        }
        elementCount--;
        elementArray[elementCount] = null;

        return obj;
    }

    public synchronized E peek() {
        int len = size();
        if (len == 0)
            throw new EmptyStackException();
        int index = len - 1;
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException(index + " >= " + elementCount);
        }
        return elementArray[index];
    }

    public boolean empty() {
        return size() == 0;
    }

    public synchronized int search(Object o) {
        int index = -1;
        int length = elementCount - 1;

        if (length >= elementCount)
            throw new IndexOutOfBoundsException(length + " >= " + elementCount);

        if (o == null) {
            for (int i = length; i >= 0; i--) {
                if (elementArray[i] == null) {
                    index = i;
                    break;
                }
            }
        } else {
            for (int i = length; i >= 0; i--) {
                if (o.equals(elementArray[i])) {
                    index = i;
                    break;
                }
            }
        }

        if (index >= 0) {
            return size() - index;
        }

        return -1;
    }

    public synchronized int size() {
        return elementCount;
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - elementArray.length > 0) {
            int oldCapacity = elementArray.length;
            int newCapacity = oldCapacity + capacityIncrement;
            if (newCapacity - minCapacity < 0)
                newCapacity = minCapacity;
            elementArray = Arrays.copyOf(elementArray, newCapacity);
        }
    }
}
