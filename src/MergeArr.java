public class MergeArr {

    public static int[] merge(int[] a, int[] b) {
        if (a == null || a.length == 0) return b;
        if (b == null || b.length == 0) return a;

        int lengthA = a.length;
        int lengthB = b.length;
        int[] c = new int[lengthA + lengthB];
        int indexA = 0, indexB = 0, indexC = 0;

        while (indexA < lengthA && indexB < lengthB) {
            if (a[indexA] < b[indexB]) {
                c[indexC++] = a[indexA++];
            } else {
                c[indexC++] = b[indexB++];
            }
        }

        if (indexA < lengthA - 1) {
            while (indexA < lengthA) {
                c[indexC++] = b[indexA++];
            }
        } else if (indexB < lengthB - 1) {
            while (indexB < lengthB) {
                c[indexC++] = b[indexB++];
            }
        }

        return c;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 6, 7, 10};
        int[] b = {1, 2, 5, 9, 11, 13};
        int[] merge = merge(a, b);
        LogUtil.printArr(merge);
    }
}
