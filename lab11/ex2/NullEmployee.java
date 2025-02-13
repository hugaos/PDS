package ex2;

public class NullEmployee extends Employee {
    public NullEmployee() {
        this.name = "Not Available";
    }

    @Override
    public String getName() {
        return name;
    }
}
