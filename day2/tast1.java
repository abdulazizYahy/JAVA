package day2;

public class tast1 {
    String name;
    double saler;
    double hireyare;

    public tast1 (String n, double s, double h) {
        name = n;
        saler = s;
        hireyare = h;

    }

    public double getHireyare() {
        return 2024 - hireyare;
    }
    public double getSaler (){
        return  saler *12;

    }
}


