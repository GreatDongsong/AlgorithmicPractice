package collection;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<E> {
    private E[] elementArray = (E[]) new Object[1];
    private int elementCount;

    public synchronized E push(E item) {
        //ensure capacity
        if (elementCount + 1 > elementArray.length) {
            elementArray = Arrays.copyOf(elementArray, elementCount + 1);
        }

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
            System.arraycopy(elementArray, size(), elementArray, index, j);
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
}
