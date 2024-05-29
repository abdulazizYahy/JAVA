package day2;
import java.util.Scanner;
public class markC {
public class CalculateMark{
    public static void main(String[] args) {
        var sc = new Scanner(System.in);

        System.out.println("Enter Mark & FullMark:  ");
        double m = sc.nextDouble();
        double f = sc.nextDouble();

        double persent = CalculateMark.markCalc(m,f);
        String status = CalculateMark.showResult(persent);

        System.out.println("you get: " + status);
    }


}

}
