import java.util.Arrays;

public class DataUtil {

    public static int[] getIntArr() {
        int[] intArr = getIntArr(5);
        System.out.println("DataUtil#getIntArr: ");
        printArr(intArr);
        return intArr;
    }

    public static int[] getIntArr(int length) {
        int[] intArr = new int[length];
        int index = 0;
        while (true) {
            int i = (int) (100 * Math.random());
            intArr[index] = i;
            index++;
            if (index == length) {
                break;
            }
        }
        return intArr;
    }

    public static void printArr(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void printMagicSquare(int[][] magicSquare) {
        for (int i = 0; i < magicSquare.length; i++)
            System.out.println(Arrays.toString(magicSquare[i]));
    }
}