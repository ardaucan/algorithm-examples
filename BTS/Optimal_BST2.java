class OptimalBSTResult {
    public int key;
    public int cost;

    public OptimalBSTResult(int key, int cost) {
        this.key = key;
        this.cost = cost;
    }
}

// Dynamic Programming Java code for Optimal Binary Search
// Tree Problem
public class Optimal_BST2 {

    /*
     * A Dynamic Programming based function that calculates
     * minimum cost of a Binary Search Tree.
     */
    static int optimalSearchTree(int keys[], int freq[], int n) {

        /*
         * Create an auxiliary 2D matrix to store results of
         * subproblems
         */
        OptimalBSTResult[][] result = new OptimalBSTResult[n + 1][n + 1];

        /*
         * cost[i][j] = Optimal cost of binary search tree that
         * can be formed from keys[i] to keys[j]. cost[0][n-1]
         * will store the resultant cost
         */
        int cost[][] = new int[n + 1][n + 1];

        // For a single key, cost is equal to frequency of the key
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
            result[i][i] = new OptimalBSTResult(keys[i], cost[i][i]);
        }

        // Now we need to consider chains of length 2, 3, ... .
        // L is chain length.
        for (int L = 2; L <= n; L++) {

            // i is row number in cost[][]
            for (int i = 0; i <= n - L + 1; i++) {

                // Get column number j from row number i and
                // chain length L
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;
                int off_set_sum = sum(freq, i, j);

                // Try making all keys in interval keys[i..j] as root
                for (int r = i; r <= j; r++) {

                    // c = cost when keys[r] becomes root of this subtree
                    int c = ((r > i) ? cost[i][r - 1] : 0)
                            + ((r < j) ? cost[r + 1][j] : 0) + off_set_sum;
                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                        result[i][j] = new OptimalBSTResult(keys[r], cost[i][j]);
                    }
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                try {
                    System.out.print("[" + result[i][j].key + " : " + result[i][j].cost + "]\t");
                } catch (NullPointerException e) {
                    System.out.print("[       ]\t");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[i].length; j++) {
                System.out.print("[" + cost[i][j] + "]");
            }
            System.out.println();
        }
        return result[0][n - 1].cost;
    }

    // A utility function to get sum of array elements
    // freq[i] to freq[j]
    static int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            if (k >= freq.length)
                continue;
            s += freq[k];
        }
        return s;
    }

    public static void main(String[] args) {

        int keys[] = { 10, 12, 20 };
        int freq[] = { 34, 8, 50 };
        int n = keys.length;
        System.out.println("Cost of Optimal BST is "
                + optimalSearchTree(keys, freq, n));
    }

}