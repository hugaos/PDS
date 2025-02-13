package lab09.ex2;

public class Employee {
    private double salary;
    private Person person;
    private EmployeeCard card;

    public Employee(Person person, double salary) {
        this.person = person;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void paySalary(double ammount) {
        BankAccount bank = person.getBankAccount();
        bank.deposit(ammount);
    }

    public void giveCard(EmployeeCard card) {
        this.card = card;
    }

    public EmployeeCard getCard() {
        return card;
    }
}
