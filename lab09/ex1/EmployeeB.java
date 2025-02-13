package lab09.ex1;
public class EmployeeB {
    private double salary;
    private Person person;

    public EmployeeB(Person person, double s) {
        this.person = person;
        this.salary = s;
    }

    public double getSalary() {
        return salary;
    }
    
    public void paySalary(double ammount) {
        BankAccount bank = person.getBankAccount();
        bank.deposit(ammount);
    }
    public BankAccount getBankAccount() {
        return person.getBankAccount();
    }
}
