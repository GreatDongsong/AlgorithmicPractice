public class Sort {

    public static void bubbleSort(int[] arr) {
        int length = arr.length;
        int index = length;
        int temp;
        while (index <= length && index >= 0) {
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
}
