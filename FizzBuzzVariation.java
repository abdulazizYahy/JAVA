 public class FizzBuzzVariation {

        public static void main(String[] args)
        {
          for (int i = 1; i <= 100; i++) {
              if (i % 3 == 0) {

                  System.out.println(i + "Fizz");

              } else if (i % 5 == 0) {

                  System.out.println(i + "Buzz");

              } else if (i % 3 == 0 && i % 5 == 0 && i % 7 == 0) {

                  System.out.println(i + "Jazz");

              }
              if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                  if (i % 3 == 0) {
                      System.out.print("Fizz");
                      if (i % 5 == 0) System.out.print("Buzz");
                      if (i % 7 == 0) System.out.print("Jazz");
                      System.out.println();
                  } else {
                      System.out.println(i);
                  }


                  for (int i1 = 1; i <= 100; i++) {
                      String result = "";

                      if (i % 3 == 0) {
                          result = "Fizz";
                      }
                      if (i % 5 == 0) {
                          result = "Buzz";
                      }
                      if (i % 7 == 0) {
                          result = "Jazz";
                      }

                      if (result.isEmpty()) {
                          result = Integer.toString(i);
                      }

                      System.out.println(result);


                      for (i = 1; i <= 100; i++) {
                          if (i % 3 == 0 && i % 5 == 0) {
                              System.out.println("FizzBuzz");
                          } else if (i % 3 == 0) {
                              System.out.println("Fizz");
                          } else if (i % 5 == 0) {
                              System.out.println("Buzz");
                          } else if (i % 7 == 0) {
                              System.out.println("Jazz");
                          } else {
                              System.out.println(i);
                          }
                      }
                  }
              }
          }  }
}