package opt;

import java.util.ArrayList;

public abstract class Source {
    private String name;
    private int supply;

    public String getName() {
        return name;
    }

    public int getSupply() {
        return supply;
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
     * suprascrierea metodei toString pentru a returna informatiile despre obiect
     */
    @Override
    public String toString() {
        return "Source name: " + this.name + " supply: " + this.supply + "\n";
    }

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
