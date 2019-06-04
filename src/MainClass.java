import sort.Bubble;
import sort.Insert;
import sort.Shell;

public class MainClass {

    public static void main(String[] args) {
        int[] intArr = DataUtil.getIntArr();
        Shell.sort(intArr);
        DataUtil.printArr(intArr);
    }
}
