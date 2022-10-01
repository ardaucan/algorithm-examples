public class App {
    public static void main(String[] args) throws Exception {
        int[] myArr = { 7, 2, 3, 4, 0, 59, 6, 1, 5 };

        // array'in sıralanacağı index aralığı girilmeli.
        int first = 0;
        int last = myArr.length - 1;

        mergeSort(myArr, first, last);
        display(myArr);
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1; // left array size
        int n2 = high - mid; // right array size

        int[] leftArr = new int[n1 + 1];
        int[] rightArr = new int[n2 + 1];

        int i, j; // i: left array index, j: right array index

        for (i = 0; i < n1; i++) {
            leftArr[i] = arr[low + i];
        }
        for (j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }
        leftArr[n1] = (int) Double.POSITIVE_INFINITY;
        rightArr[n2] = (int) Double.POSITIVE_INFINITY;

        i = 0;
        j = 0;

        for (int k = low; k <= high; k++) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
        }
    }

    /**
     * array'in elemanlarını yazdırır.
     * 
     * @param arr
     */
    static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
