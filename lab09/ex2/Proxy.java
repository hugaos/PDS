package lab09.ex2;
public class Proxy implements BankAccount{
    private BankAccountImpl bankAccount;

    public Proxy(String bank, double initialDeposit) {
        this.bankAccount = new BankAccountImpl(bank, initialDeposit);
    }
    
    @Override
    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    @Override
    public boolean withdraw(double amount) {
        if (Company.user == User.COMPANY)
            return false;
        else
            return bankAccount.withdraw(amount);
    }

    @Override
    public double balance() {
        if (Company.user == User.COMPANY)
            return 0;
        else
            return bankAccount.balance();
    }
}
