package comp;

public class Source {
    private String name;
    private int supply;
    private String type;

    public enum SourceType {
        WAREHOUSE, FACTORY
    }

    /**
     * constructor pentru initializare
     */
    public Source() {
        this.supply = 0;
        this.name = null;
        this.type = null;
    }

    public String getName() {
        return name;
    }

    public int getSupply() {
        return supply;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter pentru supply
     * daca supply-ul este pozitiv il setam
     */
    public void setSupply(int supply) {
        if (supply >= 0) {
            this.supply = supply;
        }
    }

    /**
     * verificam daca type-ul dat face parte din enum parcurgand enum-ul
     * daca nu face parte, afisam un mesaj corespunzator
     */
    public void setType(String type) {
        boolean isInEnum = false;
        for (SourceType i : SourceType.values()) {
            if (i.name().equals(type)) {
                this.type = type;
                isInEnum = true;
                break;
            }
        }
        if (!isInEnum)
            System.out.println("Type \"" + type + "\" " + "not found.");
    }

    /**
     * suprascrierea metodei toString pentru a returna informatiile despre obiect
     */
    @Override
    public String toString() {
        return "Source name: " + this.name + " supply: " + this.supply + " type: " + this.type + "\n";
    }
}
