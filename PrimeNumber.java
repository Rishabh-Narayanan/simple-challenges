package Challenges.Extra;

import java.util.Scanner;
import java.util.ArrayList;

public class PrimeNumber {
  public static double calculateSqrt(int num) {
    return Math.sqrt(num);
  }

  // public static boolean isPrime1(int num) {
  // int count = (int) Math.floor(Math.sqrt(num));
  // int i;
  // for (i = 2; i < count; i++) {
  // if (num % i == 0) {
  // return false;
  // }
  // }
  // System.out.println(i);
  // return true;
  // }

  public static boolean isPrime(int num) {
    if (Math.abs(num) < 2) {
      return false;
    }
    int count = Math.abs(num);
    for (int i = 2; i < count; i++) {
      if (Math.abs(num) % i == 0) {
        return false;
      } else {
        count = (int) Math.floor((double) Math.abs(num) / i);
      }
    }
    return true;
  }

  // public static boolean isPrime2(int num) {
  // int i;
  // for (i = 2; i < num; i++) {
  // if (num % i == 0) {
  // return false;
  // }
  // }
  // System.out.println(i);
  // return true;
  // }

  // Calculate all prime factors less than some number num
  public static ArrayList<Integer> primeOptimized(int num) {
    boolean[] a = new boolean[num + 1];
    ArrayList<Integer> list = new ArrayList<Integer>();
    a[0] = true;
    a[1] = true;
    int i = 2;
    double sq = Math.sqrt(num);
    while (i <= sq) {
      if (!a[i]) {
        for (int j = i * i; j <= num; j += i) {
          a[j] = true;
        }
      }
      i++;
    }
    for (int k = 2; k <= num; k++) {
      if (!a[k]) {
        list.add(k);
      }
    }
    return list;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("This program will find if a number is prime or not in three different ways.");

    System.out.println("What is the number?");
    int number = scan.nextInt();
    // if (check1) {
    // System.out.println("The number is prime");
    // } else {
    // System.out.println("The number is not prime");
    // }
    // if (check2) {
    // System.out.println("The number is prime");
    // } else {
    // System.out.println("The number is not prime");
    // }
    // if (check3) {
    // System.out.println("The number is prime");
    // } else {
    // System.out.println("The number is not prime");
    // }
  }
}
