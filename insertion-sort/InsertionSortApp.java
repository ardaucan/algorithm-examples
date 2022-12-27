public class InsertionSortApp {

    public static void main(String[] args) {
        int[] myArr = { 7, 3, 2, 5, 0, 7, 9, 4, 1, 8 };
        insertionSort(myArr, myArr.length);
        display(myArr);
    }

    static void insertionSort(int[] arr, int upTo) {
        for (int i = 1; i < upTo; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static void display(int[] arr) {
        String temp = "";
        for (int element : arr) {
            temp += element + ",";
        }
        System.out.println(temp.substring(0, temp.length() - 1));
    }
}
