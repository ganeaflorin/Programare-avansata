package opt;

public class Warehouse extends Source {
    /**
     * constructor pentru Warehouse
     * daca nu exista in arrayul de sources, il adaugam
     * altfel afisam un mesaj de avertizare
     *
     * @param supply  supply-ul cu care sa fie initializat
     * @param name    name-ul cu care sa fie initializat
     * @param problem o instanta a clasei Problem de care apartine obiectul
     */
    public Warehouse(int supply, String name, Problem problem) {
        this.setSupply(supply);
        this.setName(name);
        if (!problem.checkDuplicate(this))
            problem.addSource(this);
        else System.out.println("Duplicate " + this.getName() + " was not added");
    }
}

