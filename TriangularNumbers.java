package Challenges.Extra;
import java.util.Arrays;
import java.util.Scanner;
public class TriangularNumbers {
    public static void main(String[] args) {
        TriangularNumbers t = new TriangularNumbers();
        Scanner scan = new Scanner(System.in);
        System.out.println("You want to find the first triangular number which has more than how many factors?");
        int n = scan.nextInt();
        int count = 0;
        int tn = 0;
        int num = 0;
        //long start = System.currentTimeMillis();
        do {
            count++;
            tn = t.triangularNumber(count);
            num = t.calculateNumFactors(tn);
        } while (num <= n);
        //long end = System.currentTimeMillis();
        //long elapsedTime = end - start;
        System.out.println("Number: " + tn);
        System.out.println("Number of factors: " + num);
        System.out.println("Factors: " + Arrays.toString(t.getFactors(tn, num)));
        //sSystem.out.println("Duration in milliseconds: " + elapsedTime);
    }
    public int triangularNumber(int n) {
        return n * (n + 1) / 2;
    }
    //n = number;
    //num = number of factors;
    public int[] getFactors(int n, int num) {
        int[] factors = new int[num];
        int count = n;
        int counter = 0;
        for (int i = 1; i < count; i++) {
          if (n % i == 0) {
            factors[counter] = i;
            factors[num - 1 - counter] = n / i;
            counter++;
            count = n / i;
          }
        }
        return factors;
      }
    public int calculateNumFactors(int n) {
        int count = n;
        int numFactors = 0;
        for (int i = 1; i < count; i++) {
            if (n % i == 0) {
                numFactors += 2;
            }
            count = n / i;
        }
        if (count *  count == n) {
            numFactors++;
        }
        return numFactors;
    }
}