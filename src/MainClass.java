import sort.Bubble;
import sort.Insert;

public class MainClass {

    public static void main(String[] args) {
        int[] intArr = DataUtil.getIntArr();
        Insert.sort0(intArr);
        DataUtil.printArr(intArr);
    }
}
