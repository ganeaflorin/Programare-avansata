package opt;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem {
    private int[][] costMatrix;
    private int n;
    private int m;
    private ArrayList<Source> sourceList = new ArrayList<>();
    private ArrayList<Destination> destinationList = new ArrayList<>();

    /**
     * @return arrayul cu sources
     */
    public ArrayList<Source> getSourceList() {
        return this.sourceList;
    }

    /**
     * @return arrayul cu destinations
     */
    public ArrayList<Destination> getDestinationList() {
        return this.destinationList;
    }

    /**
     * adauga un obiect in arrayul cu sources
     *
     * @param source un obiect de tip Source
     */
    public void addSource(Source source) { sourceList.add(source);
    }

    /**
     * adauga un obiect in arrayul cu sources
     *
     * @param destination un obiect de tip Destination
     */
    public void addDestination(Destination destination) {
        destinationList.add(destination);
    }

    /**
     * verifica daca exista obiectul source in arrayul cu sources
     *
     * @param source un obiect cu care sa fie comparat
     * @return true daca obiectul exista in array, false in caz contrar
     */
    public boolean checkDuplicate(Source source) {
        for (Source i : sourceList) {
            if (source.equals(i))
                return true;
        }
        return false;
    }

    /**
     * verifica daca exista obiectul destination in arrayul cu destinations
     *
     * @param destination un obiect cu care sa fie comparat
     * @return true daca obiectul exista in array, false in caz contrar
     */
    public boolean checkDuplicateDestination(Destination destination) {
        for (Destination i : destinationList) {
            if (destination.equals(i))
                return true;
        }
        return false;
    }

    /**
     * constructor pentru initializare
     *
     * @param n numarul de linii
     * @param m numarul de coloane
     */
    public Problem(int n, int m) {
        costMatrix = new int[n][m];
        this.n = n;
        this.m = m;
    }

    /**
     * copiaza o matrice daca ca parametru in costMatrix
     *
     * @param matrix matricea care sa fie copiata in costMatrix
     */
    public void setMatrix(int[][] matrix) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                costMatrix[i][j] = matrix[i][j];
    }

    /**
     * cauta pe o linie din matrice costul minim
     *
     * @param line linia care corespunde unui obiect de tip Source
     * @return costul minim de pe linia cautata
     */
    public int getMinCost(int line) {
        int min = 999999;
        for (int j = 0; j < m; j++)
            if (min > costMatrix[line][j] && destinationList.get(j).getDemand() > 0)
                min = costMatrix[line][j];
        return min;
    }

    /**
     * cautam pe o linie un cost si daca il gasim returnam indexul lui
     *
     * @param cost costul cautat pe o anumita linie
     * @param line linia pe care cautam costul
     * @return indexul costului cautat pe linia line
     */
    public int getIndexMinCost(int cost, int line) {
        for (int j = 0; j < m; j++)
            if (cost == costMatrix[line][j])
                return j;
        return -1;
    }

    /**
     * printeaza matricea de costuri
     */
    public void printCostMatrix() {
        System.out.println("Cost matrix:");
        System.out.print("        ");
        for (int i = 0; i < m; i++)
            System.out.print("D" + (i + 1) + "  ");
        System.out.println();
        for (int i = 0; i < n; i++) {
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

    /**
     * @return marimea listei de obiecte Source
     */
    public int getListSize() {
        return sourceList.size();
    }

    /**
     * printeaza obiectele de tip Source din arrayul de sources
     */
    public void printSourceList() {
        for (Source i : sourceList) {
            System.out.print(i.toString());
        }
    }

    /**
     * printeaza obiectele de tip Destination din arrayul de destinations
     */
    public void printDestinationList() {
        for (Destination i : destinationList) {
            System.out.print(i.toString());
        }
    }
}
