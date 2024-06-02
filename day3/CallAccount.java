package day3;

public class CallAccount {
    public static void main(String[] args) {


        SavingAccount s1 = new SavingAccount("seed",  2000, 100);
        ChecKingAccount c1 = new ChecKingAccount("Abdulaziz", 47513);

        s1.withdraw(127);
        c1.withdraw(200);

        printDetails(s1);
        System.out.println("________");
        printDetails(c1);
    }

    public static void printDetails(Account a){
        System.out.println(a.name);
        System.out.println(a.getBalance());
        if (a instanceof SavingAccount){
            System.out.println(((SavingAccount) a).getLimit());
        }
    }
}


