package opt;

public class Factory extends Source {
    public Factory(int supply, String name, Problem problem) {
        this.setSupply(supply);
        this.setName(name);
        if (!problem.checkDuplicate(this))
            problem.addSource(this);
        else System.out.println("Duplicate " + this.getName() + " was not added");
    }

}
