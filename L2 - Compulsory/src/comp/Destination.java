package comp;

public class Destination {
    private String name;
    private int demand;

    /**
     * constructor pentru initializare
     */
    public Destination() {
        this.name = null;
        this.demand = 0;
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
}
