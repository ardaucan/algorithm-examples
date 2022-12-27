public class Q2 {

    public static void main(String[] args) {
        for (int n = 10000; n <= 100000; n += 10000) {
            int[] arr = new int[n];
            generateRandomArray(arr, n); // fills the array with numbers between 0 and n.

            long start = System.nanoTime();
            quicksort(arr, 0, arr.length - 1);
            int duration = (int) (System.nanoTime() - start);

            System.out.printf("Algorithm took %d ns for n=%d.\n", duration, n);
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

    static void generateRandomArray(int[] arr, int upperLimit) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * upperLimit);
        }
    }

    static void printArray(int[] arr) {
        String ret = "";
        for (int i : arr) {
            ret += i + ", ";
        }
        ret = ret.substring(0, ret.length() - 2);
        System.out.println(ret);
    }
}