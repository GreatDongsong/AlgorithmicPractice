package sort;


public class Bubble {


    /*
     *基本思想:将数组中最大的元素冒泡到最后，然后逐渐缩小遍历范围
     *遍历结束条件是遍历完整个数组
     */
    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        int index = length;
        int temp;
        while (index >= 0) {
            for (int i = 1; i < index; i++) {
                if (arr[i - 1] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
            index--;
        }
    }

    /*
     * 基本思想:将数组中最大的元素冒泡到最后，然后逐渐缩小遍历范围
     * 遍历结束条件是发现没有课发现没有可互换位置的元素的时候
     */
    public static void bubbleSort1(int[] arr) {
        int index = arr.length;
        int temp;
        boolean flag = true;
        while (flag) {
            for (int i = 1; i < index; i++) {
                if (arr[i - 1] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    flag = true;
                } else {
                    flag = false;
                }
            }
            index--;
        }
    }

    /*
     * 基本思想:将数组中最大的元素冒泡到最后，然后逐渐缩小遍历范围，动态更新遍历范围
     * 遍历结束条件是发现没有可交换的元素
     */
    public static void bubbleSort2(int[] arr) {
        int indexLastSwap;
        int temp;
        int currIndex = arr.length;
        while (currIndex != 0) {
            indexLastSwap = currIndex;
            currIndex = 0;
            for (int i = 1; i < indexLastSwap; i++) {
                if (arr[i - 1] > arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    currIndex = i;
                }
            }
        }
    }

}
