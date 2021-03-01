package opt;

import java.util.ArrayList;

public abstract class Source {
    private String name;
    private int supply;

    /**
     * @return numele obiectului
     */
    public String getName() {
        return name;
    }

    /**
     * @return supplyul obiectului
     */
    public int getSupply() {
        return supply;
    }

    /**
     * seteaza name-ul
     *
     * @param name numele care sa fie setat
     */
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
     * @return string cu detaliile despre obiect
     */
    @Override
    public String toString() {
        return "Source name: " + this.name + " supply: " + this.supply + "\n";
    }

    /**
     * @param source obiect cu care este comparat
     * @return true daca obiectele sunt de acelasi tip, au acelasi nume si acelasi demand, false in caz contrar
     */
    @Override
    public boolean equals(Object source) {
        if (source == null) {
            return false;
        }
        Source tempSource = (Source) source;
        if (this.name != tempSource.name) {
            return false;
        }
        if (this.supply != tempSource.supply) {
            return false;
        }
        return true;
    }
}
