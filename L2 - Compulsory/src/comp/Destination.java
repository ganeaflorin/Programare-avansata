package comp;

public class Destination {
    private String name;
    private int demand;

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

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "name: "+this.name+" demand: "+this.demand+"\n";
    }
}
