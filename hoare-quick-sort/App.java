/**
 * App
 */
public class App {

    public static void main(String[] args) {
        int[] arr = { 5, 3, 2, 6, 4, 1, 3, 7 };
        quicksort(arr, 0, arr.length - 1);
        // int ret = partition(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ", ");
        }
    }

    static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int part = partition(arr, low, high);
            quicksort(arr, low, part);
            quicksort(arr, part + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low - 1, j = high + 1;

        while (true) {
            do {
                j--;
            } while (arr[j] > pivot);

            do {
                i++;
            } while (arr[i] < pivot);

            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            } else {
                return j;
            }
        }
    }
}