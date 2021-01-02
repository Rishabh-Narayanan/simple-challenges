package Challenges.Extra;
import java.util.Scanner;
import java.util.Arrays;
public class Factors {
  public static int numFactors(int n) {
    int count = n;
    int counter = 0;
    int mid = 0;
    int i;
    for (i = 1; i < count; i++) {
      if (n % i == 0) {
        count = n / i;
        counter++;
        mid = i;
      }
    }
    if (mid == count) {
      
      return counter * 2 - 1;
    } else {
      
      return counter * 2;
    }
  }
  public static int[] getFactors(int n) {
    int count = n;
    int counter = 0;
    int[] factors = new int[numFactors(n)];
    int l = factors.length - 1;
    for (int i = 1; i < count; i++) {
      if (n % i == 0) {
        factors[counter] = i;
        factors[l - counter] = n / i;
        counter++;
        count = n / i;
      }
    }
    return factors;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("This program will list all the factors of a number, n");
    System.out.println("What is n?");
    int n = scan.nextInt();
    System.out.println("The factors are: ");
    int[] factorArray = getFactors(n);
    System.out.println(Arrays.toString(factorArray));
  }
}
