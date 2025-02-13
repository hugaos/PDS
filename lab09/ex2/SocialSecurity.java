package lab09.ex2;

import java.util.ArrayList;

public class SocialSecurity {
    private ArrayList<Employee> aderentes;

    public SocialSecurity() {
        this.aderentes = new ArrayList<>();
    }

    public void regist(Employee employee) {
        this.aderentes.add(employee);
    }

    public ArrayList<Employee> getAderentes() {
        return this.aderentes;
    }
}
