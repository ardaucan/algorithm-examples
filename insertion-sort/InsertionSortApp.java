public class InsertionSortApp {

    public static void main(String[] args) {
        int[] myArr = {3,2,5,0,9,4,1,8};
        insertionSort(myArr, 7);
        display(myArr);
    }

    static void insertionSort(int[] arr, int idx){
        for (int i = 1; i <= idx; i++) {
            
            int j = i;
            int key = arr[j];
            
            while(j > 0 && key < arr[j-1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;                        
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
