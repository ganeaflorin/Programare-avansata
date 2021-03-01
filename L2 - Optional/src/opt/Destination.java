package opt;

public class Destination {
    private String name;
    private int demand;

    /**
     * constructor pentru obiecte de tip Destination
     * daca nu exista duplicat, il adaugam in array-ul de destinatii
     * altfel afisam un mesaj de atentionare
     *
     * @param demand  demand-ul cu care sa fie initializat
     * @param name    name-ul cu care sa fie initializat
     * @param problem o instanta a clasei Problem de care apartine obiectul
     */
    public Destination(int demand, String name, Problem problem) {
        this.demand = demand;
        this.name = name;
        if (!problem.checkDuplicateDestination(this))
            problem.addDestination(this);
        else System.out.println("Duplicate " + this.getName() + " was not added");
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return demand
     */
    public int getDemand() {
        return demand;
    }

    /**
     * seteaza demand daca e pozitiv
     *
     * @param demand demandul care sa fie setat
     */
    public void setDemand(int demand) {

        if (demand >= 0)
            this.demand = demand;
    }

    /**
     * seteaza numele
     *
     * @param name numele care sa fie setat
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return string cu detaliile despre obiect
     */
    @Override
    public String toString() {
        return "Destination name: " + this.name + " demand: " + this.demand + "\n";
    }

    /**
     * @param destination obiect cu care este comparat
     * @return true daca obiectele sunt de acelasi tip, au acelasi nume si acelasi demand, false in caz contrar
     */
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
        return this.demand == tempDestination.demand;
    }
}
