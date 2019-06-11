public class MergeArr {

    public static Integer[] merge(Integer[] a, Integer[] b) {
        if (a == null || a.length == 0) return b;
        if (b == null || b.length == 0) return a;

        int lengthA = a.length;
        int lengthB = b.length;
        Integer[] c = new Integer[lengthA + lengthB];
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
        Integer[] a = {1, 3, 6, 7, 10};
        Integer[] b = {1, 2, 5, 9, 11, 13};
        Integer[] merge = merge(a, b);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i]);
        }
    }
}
