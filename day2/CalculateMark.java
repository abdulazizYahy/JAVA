package day2;

public class CalculateMark {

        public static double markCalc(double mark, double fullMark) {

            return (mark / fullMark) * 100;
        }

        public static String showResult(double persent) {

            if (persent > 85) return "Exellent";
            else if (persent > 75) return "Very Good";
            else if (persent > 65) return "Good";
            else if (persent >= 50) return "pass";
            else return "Fail";

        }
    }

