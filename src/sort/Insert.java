package sort;

public class Insert {
    /*
     * 基本思想：假设前n个元素是有序的，逐渐将剩余的元素插入前n个元素
     *
     *
     */
    public static void sort0(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    break;
                }
            }
        }

    }

}
