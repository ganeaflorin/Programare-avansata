package opt;

/**
 * Ganea Florin 2A5
 */
public class Main {
    public static void main(String[] args) {
        /**
         * instantiere obiecte Destinatie, Sursa si Problem
         */
        int n = 3, m = 3;
        Problem problem = new Problem(n, m);
        Destination d1 = new Destination(20, "d1", problem);
        Destination d2 = new Destination(25, "d2", problem);
        Destination d3 = new Destination(25, "d3", problem);
        Destination d4 = new Destination(25, "d3", problem);

        Factory s1 = new Factory(10, "s1", problem);
        Warehouse s2 = new Warehouse(35, "s2", problem);
        Warehouse s3 = new Warehouse(25, "s3", problem);
        Warehouse s4 = new Warehouse(25, "s3", problem);
        /**
         * printare sources si destinations
         */
        problem.printSourceList();
        problem.printDestinationList();
        /**
         * creare matrice pentru setarea matricei de costuri
         */
        int[][] tempMatrix = {{2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}};
        problem.setMatrix(tempMatrix);
        problem.printCostMatrix();
        /**
         * instantiere solutie + apelare
         */
        Solution solution = new Solution(problem);
        solution.solution();

    }

}
