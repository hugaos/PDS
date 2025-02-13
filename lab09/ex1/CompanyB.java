package lab09.ex1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class CompanyB {
    public static User user;
    private List<EmployeeB> emps = new ArrayList<>();

    public void paySalaries(int month) {
        for (EmployeeB e : emps) {
            BankAccount ba = e.getBankAccount();
            ba.deposit(e.getSalary());
        }
    }

    public List<EmployeeB> employees() {
        return Collections.unmodifiableList(emps);

    }
    public void admitEmployee(Person person, double salary) {
        EmployeeB e = new EmployeeB(person, salary);
        emps.add(e);
    }
}
