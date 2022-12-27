public class Q1 {

    static Subproblem[][] optimalSearchTree(int keys[], int freq[], int n) {

        int cost[][] = new int[n + 1][n + 1];

        /*
         * auxiliary 2D matrix to store root node and cost of the subproblems
         */
        Subproblem[][] subproblems = new Subproblem[n + 1][n + 1];

        /*
         * subproblems[i][j] = Pair of root node and cost of the optimal binary
         * search tree that can be formed from keys[i] to keys[j].
         * 
         * subproblems[0][n-1] will store our result.
         */
        // For a single key, cost is equal to frequency of the key
        for (int i = 0; i < n; i++) {
            cost[i][i] = freq[i];
            subproblems[i][i] = new Subproblem(keys[i], freq[i]);
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
                        subproblems[i][j] = new Subproblem(keys[r], c);
                    }
                }
            }
        }
        return subproblems;
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

class Subproblem {
    int root; // root node of the subproblem
    int cost; // cost of the subproblem

    public Subproblem(int root, int cost) {
        this.root = root;
        this.cost = cost;
    }
}