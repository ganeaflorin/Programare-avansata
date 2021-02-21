package comp;

public class Problem {
    private int[][] costMatrix;
    private int n;
    private int m;

    public Problem(int n, int m) {
        costMatrix = new int[n][m];
        this.n = n;
        this.m = m;
    }

    public void setMatrix(int[][] matrix) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                costMatrix[i][j] = matrix[i][j];
    }

    public int[][] getMatrix() {
        return costMatrix;
    }

    public void printCostMatrix() {
        System.out.println("Cost matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(costMatrix[i][j]+" ");
            System.out.println();
        }
    }
}
