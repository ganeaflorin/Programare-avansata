package opt;

public class Destination {
    private String name;
    private int demand;

    /**
     * constructor pentru initializare
     */
    public Destination(int demand, String name, Problem problem) {
        this.demand = demand;
        this.name = name;
        if (!problem.checkDuplicateDestination(this))
            problem.addDestination(this);
        else System.out.println("Duplicate " + this.getName() + " was not added");
    }

    public String getName() {
        return name;
    }

    public int getDemand() {
        return demand;
    }

    /**
     * setter pentru demand
     * daca demandul este pozitiv il setam
     */
    public void setDemand(int demand) {

        if (demand >= 0)
            this.demand = demand;
    }


    public void setName(String name) {
        this.name = name;
    }

    /**
     * suprascrierea metodei toString pentru a returna informatiile despre obiect
     */
    @Override
    public String toString() {
        return "Destination name: " + this.name + " demand: " + this.demand + "\n";
    }

    @Override
    public boolean equals(Object destination) {
        if (destination == null) {
            return false;
        }
        if (this.getClass() != destination.getClass()) {
            return false;
        }
        Destination tempDestination = (Destination) destination;
        if (this.name != tempDestination.name) {
            return false;
        }
        if (this.demand != tempDestination.demand) {
            return false;
        }
        return true;
    }
}
