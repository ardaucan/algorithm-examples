public class InsertionSortApp {

    public static void main(String[] args) {
        int[] myArr = {1,2,3,4,6,7,5};
        insertionSort(myArr, 6);
        display(myArr);
    }

    static void insertionSort(int[] arr, int idx){
        int temp = arr[idx];
        while (idx != 0){
            if (temp < arr[idx-1]){
                arr[idx] = arr[idx-1];
            } else {
                arr[idx] = temp;
                break;
            }
            idx--;
        }
    }

    static void display(int[] arr) {
        String temp = "";
        for (int element : arr) {
            temp += element + ",";
        }
        System.out.println(temp.substring(0, temp.length()-1));
    }
}
