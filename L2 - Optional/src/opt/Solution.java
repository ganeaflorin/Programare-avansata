package opt;

import java.util.ArrayList;

public class Solution {
    Problem problem;

    /**
     * constructor pentru Solution care preia o problema
     *
     * @param problem o instantie a clasei Problem
     */
    public Solution(Problem problem) {
        this.problem = problem;
    }

    /**
     * metoda pentru calcularea solutiei
     * calculam sumele de supply si de demand
     * daca nu sunt egale afisam un mesaj si iesim din metoda
     * parcurgem arrayul de surse
     * atat timp cat sursa mai are de satisfacut supply-ul
     * luam costul minim de pe linia sursei corespunzatoare
     * actualizam supply-ul si demand-ul
     * calculam costul total adaugand la fiecare pas cost*unitati si il afisam
     */
    public void solution() {
        int supplySum = 0, demandSum = 0;

        ArrayList<Destination> destinations = problem.getDestinationList();
        ArrayList<Source> sources = problem.getSourceList();
        for (Destination dest : destinations) {
            demandSum += dest.getDemand();
        }
        for (Source source : sources) {
            supplySum += source.getSupply();
        }
        if (supplySum != demandSum) {
            System.out.println("The sum of demands must be equal to the sum of the supplies.");
            return;
        }
        int solutionCost = 0;
        for (Source source : sources) {
            while (source.getSupply() > 0) {
                int units;
                int cost = problem.getMinCost(sources.indexOf(source));
                int index = problem.getIndexMinCost(cost, sources.indexOf(source));
                int supply = source.getSupply();
                int demand = destinations.get(index).getDemand();
                if (supply >= demand) {
                    source.setSupply(supply - demand);
                    destinations.get(index).setDemand(0);
                    units = demand;
                } else {
                    destinations.get(index).setDemand(demand - supply);
                    source.setSupply(0);
                    units = supply;
                }
                System.out.println("S" + (sources.indexOf(source) + 1) + "-> D" +
                        (index + 1) + ": " + units + " units * cost " + cost + " = " + (cost * units));
                solutionCost += (cost * units);
            }
        }
        System.out.println("Total cost: " + solutionCost);
    }
}
