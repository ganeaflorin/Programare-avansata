package comp;

public class Main {
    public static void main(String[] args) {
        /**
         * instantiere obiecte Destinatie, Sursa si Problem
         */
        Destination d1 = new Destination();
        Destination d2 = new Destination();
        Destination d3 = new Destination();
        Source s1 = new Source();
        Source s2 = new Source();
        Source s3 = new Source();
        /**
         * n = numarul de linii ale matricei
         * m = nr de coloane
         */
        int n = 4, m = 4;
        Problem costs = new Problem(n, m);
        /**
         * setarea parametrilor obiectelor
         */
        d1.setDemand(20);
        d1.setName("d1");
        d2.setDemand(25);
        d2.setName("d2");
        d3.setDemand(25);
        d3.setName("d3");

        s1.setSupply(10);
        s1.setName("s1");
        s1.setType("FACTORY");
        s2.setSupply(35);
        s2.setName("s2");
        s2.setType("WAREHOUSE");
        s3.setSupply(25);
        s3.setName("s3");
        s3.setType("WAREHOUSE");

        System.out.println(d1.toString() + d2.toString() + d3.toString() + s1.toString() + s2.toString() + s3.toString());

        /**
         * creare matrice pentru setarea matricei de costuri
         */
        int[][] tempMatrix = {{2, 3, 1, s1.getSupply()}, {5, 4, 8, s2.getSupply()}, {5, 6, 8, s3.getSupply()}, {d1.getDemand(), d2.getDemand(), d3.getDemand(), -1}};
        costs.setMatrix(tempMatrix);
        costs.printCostMatrix();
//        System.out.println(costs.toString());
    }

}
