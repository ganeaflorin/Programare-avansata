package opt;

public class Main {
    public static void main(String[] args) {


        /**
         * instantiere obiecte Destinatie, Sursa si Problem
         */
        int n = 4, m = 4;
        Problem problem = new Problem(n, m);
        Destination d1 = new Destination(20, "d1", problem);
        Destination d2 = new Destination(25, "d2", problem);
        Destination d3 = new Destination(25, "d3", problem);
        Destination d4 = new Destination(25, "d3", problem);

        Factory s1 = new Factory(10, "s1", problem);
        Warehouse s2 = new Warehouse(35, "s2", problem);
        Warehouse s3 = new Warehouse(25, "s3", problem);
        Warehouse s4 = new Warehouse(25, "s3", problem);

        problem.printSourceList();
        problem.printDestinationList();


        /**
         * creare matrice pentru setarea matricei de costuri
         */
        int[][] tempMatrix = {{2, 3, 1, s1.getSupply()},
                {5, 4, 8, s2.getSupply()},
                {5, 6, 8, s3.getSupply()},
                {d1.getDemand(), d2.getDemand(), d3.getDemand(), -1}};
        problem.setMatrix(tempMatrix);
        problem.printCostMatrix();

    }

}
