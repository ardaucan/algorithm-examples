public class Q3 {

    public static void main(String[] args) throws InterruptedException {
        int n = (int) Math.pow(2, 16);
        int myArr[] = new int[n];
        generateSortedRandomArray(myArr); // inserts non-duplicate random numbers to myArr in ascending order.

        // an array for k values: { 1, n/16, 2n/16 ... 15n/16, n-1 }
        int[] k = new int[17];
        k[0] = 1;
        k[16] = n - 1;
        for (int i = 1; i <= 15; i++) {
            k[i] = i * n / 16;
        }

        /*
         * shifts the array for each k value and measures the running time of
         * insertionSort.
         */
        for (int i = 0; i < k.length; i++) {
            rightShift(myArr, k[i]);

            long start = System.currentTimeMillis();
            insertionSort(myArr, myArr.length - 1); // sorts whole array
            long duration = System.currentTimeMillis() - start;

            System.out.printf("Algorithm took %dms for k=%d \n", duration, k[i]);
        }
    }

    static void insertionSort(int[] arr, int idxUpTo) {
        for (int i = 1; i <= idxUpTo; i++) {
            int j = i;
            int key = arr[j];

            while (j > 0 && key < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key;
        }
    }

    static void rightShift(int[] arr, int k) {
        k = k % arr.length;
        for (int i = 0; i < k; i++) {
            int temp = arr[arr.length - 1];
            for (int j = arr.length - 2; j >= 0; j--) {
                arr[j + 1] = arr[j];
            }
            arr[0] = temp;
        }
    }

    static void generateSortedRandomArray(int[] arr) {
        arr[0] = (int) (Math.random() * 10);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + (int) (1 + Math.random() * 10);
        }
    }

    static void printArray(int[] arr) {
        String temp = "";
        for (int element : arr) {
            temp += element + ",";
        }
        System.out.println(temp.substring(0, temp.length() - 1));
    }
}
