public class MainClass {

    public static void main(String[] args) {
        int[] intArr = DataUtil.getIntArr();
        Sort.bubbleSort2(intArr);
        DataUtil.printArr(intArr);
    }
}
