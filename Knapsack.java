public class Knapsack {
    public void solve(int[] weights, int[] profits, int knapsackWeight, int itemCount) {
        int NEG_INF = Integer.MIN_VALUE;
        int[][] m = new int[itemCount + 1][knapsackWeight + 1];
        int[][] solution = new int[itemCount + 1][knapsackWeight + 1];

        for (int i = 1; i <= itemCount; i++) {
            for (int j = 0; j <= knapsackWeight; j++) {
                int m1 = m[i - 1][j];
                int m2 = NEG_INF;
                if (j >= weights[i])
                    m2 = m[i - 1][j - weights[i]] + profits[i];
                m[i][j] = Math.max(m1, m2);
                solution[i][j] = m2 > m1 ? 1 : 0;
            }
        }

        int[] selected = new int[itemCount + 1];
        for (int n = itemCount, w = knapsackWeight; n > 0; n--) {
            if (solution[n][w] != 0) {
                selected[n] = 1;
                w = w - weights[n];
            } else
                selected[n] = 0;
        }

        System.out.print("\nItems with weight ");
        for (int i = 1; i < itemCount + 1; i++)
            if (selected[i] == 1)
                System.out.print(weights[i] + " ");
        System.out.println("are selected by knapsack algorithm.");
    }

    public static void main(String[] args) {
        Knapsack ks = new Knapsack();

        int[] weights = {0, 3, 4, 6, 5};
        int[] profits = {0, 2, 3, 1, 4};
        int itemCount = 4;
        int knapsackWeight = 8;

        ks.solve(weights, profits, knapsackWeight, itemCount);

    }
}
