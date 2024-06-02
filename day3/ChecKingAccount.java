package day3;

public class ChecKingAccount extends Account {
   private int limit ;

    public ChecKingAccount(String name, double balance) {
        super(name, balance);
    }

    public ChecKingAccount(String name, int balance) {
        super(name, balance);
    }

    @Override
    public void withdraw(int amount){

        if ( getBalance() - amount >= 0){
            super.withdraw(amount);

        }

    }
}


