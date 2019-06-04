package sort;

public class Shell {
    public static void sort(int[] arr) {
        int length = arr.length;
        int half = length;
        int temp;
        while (half > 0) {
            for (int i = 0; i < half; i++) {
                for (int j = i; j > 0; j--) {
                    if (arr[j - 1] > arr[j]) {
                        temp = arr[j - 1];
                        arr[j - 1] = arr[j];
                        arr[j] = temp;
                    }else {
                        break;
                    }
                }
            }
            half = half / 2;
        }
    }
}
