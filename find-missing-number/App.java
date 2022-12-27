public class App {

    public static void main(String[] args) {
        // int previousDuration = 0;

        // for (int n = 10000; n <= 100000; n += 10000) {
        // int[] arr = new int[n];
        // randomArray(arr, 100000); // fills the array with numbers between 0 and
        // 100000.

        // long start = System.currentTimeMillis();
        // quicksort(arr, 0, arr.length - 1);
        // int duration = (int) (System.currentTimeMillis() - start);

        // String str = "Algorithm took " + duration + "ms with n=" + n + ".";
        // str += " Amount of increase: " + (duration - previousDuration) + "ms.";
        // System.out.println(str);

        // previousDuration = duration;
        // }

        int[] arr = { 12, 7, 10, 9, 5, 4, 11, 1, 6, 8, 2 };
        findMissingNumber(arr, 0, arr.length - 1);
        printArray(arr);
    }

    static void findMissingNumber(int[] arr, int low, int high) {
        if (low < high) {
            int part = partition(arr, low, high);
            findMissingNumber(arr, low, part);
            findMissingNumber(arr, part + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2];
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

    static void randomArray(int[] arr, int upperLimit) {
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