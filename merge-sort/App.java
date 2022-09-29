public class App {
    public static void main(String[] args) throws Exception {
        int[] myArr = {7,2,3,4,0,59,6,1,5};
        
        // array'in sıralanacağı index aralığı girilmeli. 
        int first = 0;
        int last = myArr.length-1;

        mergeSort(myArr, first, last);
        display(myArr);
    }

    static void mergeSort(int[] arr, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(arr, p, q);
            mergeSort(arr, q+1, r);
            merge(arr, p, q, r);
        }
    }

    static void merge(int[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        
        int[] leftArr = new int[n1+1];
        int[] rightArr = new int[n2+1];
        
        int i, j;

        for (i = 0; i < n1; i++) {
            leftArr[i] = arr[p + i];
        }
        for (j = 0; j < n2; j++) {
            rightArr[j] = arr[q + j + 1];
        }
        leftArr[n1] = (int) Double.POSITIVE_INFINITY;
        rightArr[n2] = (int) Double.POSITIVE_INFINITY;

        i = 0;
        j = 0;
        

        for (int k = p; k < r + 1; k++) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            }
            else {
                arr[k] = rightArr[j];
                j++;
            }
        }
    }

    /**
     * array'in elemanlarını yazdırır.
     * @param arr
     */
    static void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
