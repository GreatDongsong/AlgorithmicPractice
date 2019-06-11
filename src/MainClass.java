import sort.Shell;

public class MainClass {

    public static void main(String[] args) {
        int[] intArr = LogUtil.getIntArr();
        Shell.sort(intArr);
        LogUtil.printArr(intArr);
    }
}
