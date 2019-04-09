public class Sort {

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

    public static void bubbleSort1(int[] arr) {
        int index = arr.length;
        int temp;
        boolean flag = true;
        while (flag) {
            for (int i = 1; i < index; i++) {
                if (arr[i - 1] < arr[i]) {
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

    public static void bubbleSort2(int[] arr) {
        int lastSwapIndex = arr.length;
        int temp;
        int currIndex = arr.length;
        while (currIndex != 0) {
            lastSwapIndex = currIndex;
            currIndex = 0;
            for (int i = 1; i < lastSwapIndex; i++) {
                if (arr[i - 1] < arr[i]) {
                    temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    currIndex = i;
                }
            }
        }
    }

}
