package Challenges.Extra;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeFactors {
    public static int numPrimeElements(int[] factors) {
        int count = 0;
        for (int i : factors) {
            if(PrimeNumber.isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    public static int[] getPrimeElements(int[] factors) {
        int[] primeFactors = new int[numPrimeElements(factors)];
        int count = 0;
        for (int i : factors) {
            if(PrimeNumber.isPrime(i)) {
                primeFactors[count] = i;
                count++;
            }
        }
        return primeFactors;
    }
    public static int[] getPrimeFactors(int number) {
        int [] factors = Factors.getFactors(number);
        int[] primeFactors = new int[numPrimeElements(factors)];
        int count = 0;
        for (int i : factors) {
            if(PrimeNumber.isPrime(i)) {
                primeFactors[count] = i;
                count++;
            }
        }
        return primeFactors;
    }
    public static int[][] getPrimeFactorization(int n) {
        int [] pFactorArray = getPrimeFactors(n);
        int [][] pFactorization = new int[pFactorArray.length][2];
        for (int i = 0; i < pFactorArray.length; i++) {
            int j = pFactorArray[i];
            pFactorization[i][0] = j;
            while (true) {
                if (n % j == 0) {
                    n /= j;
                    pFactorization[i][1]++;
                } else {
                    break;
                }
            }
        }

        //returns 2d array in the form of [ [factor, exponent] ]  for all prime factors
        return pFactorization;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program will calculate all prime factors and the prime factorization of a number, n");
        System.out.println("What is n?");

        int number = scan.nextInt();

        //Takes all factors as an input and stores all prime factors in a new array
        System.out.println(Arrays.toString(getPrimeFactors(number)));
        System.out.println(Arrays.deepToString(getPrimeFactorization(number)));
        
    }
}
