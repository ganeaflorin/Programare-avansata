package opt;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem {
    private int[][] costMatrix;
    private int n;
    private int m;
    private ArrayList<Source> sourceList = new ArrayList<>();
    private ArrayList<Destination> destinationList = new ArrayList<>();

    public void addSource(Source source) {
        sourceList.add(source);
    }

    public boolean checkDuplicate(Source source) {
        for (Source i : sourceList) {
            if (source.equals(i))
                return true;
        }
        return false;
    }

    public void addDestination(Destination destination) {
        destinationList.add(destination);
    }

    public boolean checkDuplicateDestination(Destination destination) {
        for (Destination i : destinationList) {
            if (destination.equals(i))
                return true;
        }
        return false;
    }

    public Problem(int n, int m) {
        costMatrix = new int[n][m];
        this.n = n;
        this.m = m;
    }

    /**
     * copiaza in matricea costMatrix matricea data ca parametru
     */
    public void setMatrix(int[][] matrix) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                costMatrix[i][j] = matrix[i][j];
    }


    /**
     * metoda printeaza matricea sub forma exemplului (cu valorile pentru demand si pentru supply)
     */
    public void printCostMatrix() {
        System.out.println("Cost matrix:");
        System.out.print("        ");
        for (int i = 1; i < m; i++)
            System.out.print("D" + i + "  ");
        System.out.println("Supply");
        for (int i = 0; i < n; i++) {
            if (i + 1 == n) System.out.print("Demand  ");
            else
                System.out.print("S" + (i + 1) + "      ");
            for (int j = 0; j < m; j++)
                if (costMatrix[i][j] < 10) System.out.print(costMatrix[i][j] + "   ");
                else
                    System.out.print(costMatrix[i][j] + "  ");
            System.out.println();
        }
    }

    /**
     * suprascrierea metodei toString pentru a returna informatiile despre obiect
     */
    @Override
    public String toString() {
        return "costMatrix=" + Arrays.toString(costMatrix) + ", n=" + n + ", m=" + m;
    }

    public int getListSize() {
        return sourceList.size();
    }

    public void printSourceList() {
        for (Source i : sourceList) {
            System.out.print(i.toString());
        }
    }

    public void printDestinationList() {
        for (Destination i : destinationList) {
            System.out.print(i.toString());
        }
    }
}
