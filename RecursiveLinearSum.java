package Challenges.Extra;
import java.util.Scanner;
import java.util.regex.*;
public class RecursiveLinearSum {
  private static double a;
  private static String signA;
  private static String signB;
  private static double b;
  private static int iteration;
  private static double endingValue;
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("This program will calculate the value at which you started at, " + 
    "given the ending value and a recursive equation.");


    System.out.println("What is the recursive linear equation (ax + b) (a != 1)");
    String equation = scan.nextLine();
    regexChecker(equation);
    signChange();
    System.out.println("How many times to do you want to iterate?");
    iteration = scan.nextInt();
    System.out.println("What value do you want to end at?");
    endingValue = scan.nextDouble();
    System.out.println("You started at this value: " + calcIteration());
  }
  public static void regexChecker(String stringCheck) {
    Pattern regexCheck = Pattern.compile("\\b([-]?) *(\\d+)x *([-+]) *(\\d+)\\b");
    Matcher regexMatch = regexCheck.matcher(stringCheck);
    while (regexMatch.find()) {
      signA = regexMatch.group(1);
      a = Double.parseDouble(regexMatch.group(2));
      signB = regexMatch.group(3);
      b = Double.parseDouble(regexMatch.group(4));
    }
  }
  public static void signChange() {
    if (signA.equals("-")) {
      a = -a;
    }
    if (signB.equals("-")) {
      b = -b;
    }
  }
  public static double calcIteration() {
    return (endingValue - ((Math.pow(a, iteration) - 1)*b / (a - 1)))/ Math.pow(a, iteration);
  }
}
