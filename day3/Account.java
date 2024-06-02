package day3;

public class Account {
String name ;
double balanes ;
static double anulRate =0.05;

public Account (String name , double balanes){

    this.name =name ;
    this.balanes = balanes ;


}
  public double getMothlyRate(){
      return anulRate / 12 ;

  }
    public double getMonthlyRate(){
        return balanes * getMonthlyRate();
    }
    public void withdraw(int amount){
        amount -= balanes ;

    }
    public double getBalance(){
        return balanes ;
    }
}
