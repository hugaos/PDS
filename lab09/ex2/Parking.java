package lab09.ex2;

import java.util.ArrayList;

public class Parking {
    private ArrayList<Employee> permitidos;

    public Parking() {
        this.permitidos = new ArrayList<>();
    }

    public void allow(Employee employee) {
        this.permitidos.add(employee);
    }

    public ArrayList<Employee> getPermitidos() {
        return this.permitidos;
    }
}
