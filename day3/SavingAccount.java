package day3;

public class SavingAccount extends Account{
    private int limit;

    public SavingAccount(String name, double balance, int limit) {
        super(name, balance);
        this.limit = limit;
    }

    @Override
    public void withdraw(int amount){
        if (getBalance() - amount >= limit){
            super.withdraw(amount);
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}


