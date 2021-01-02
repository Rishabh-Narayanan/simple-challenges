package Challenges.Extra;

import java.util.Scanner;
import java.util.ArrayList;
public class OrderNumbers {
  private static ArrayList<Integer> numbers = new ArrayList<Integer>();
  public static void getEach(String seq) {
    int prevI = 0;
    for (int i = 0; i < seq.length(); i++) {
      if (seq.charAt(i) == ' ') {
        numbers.add(Integer.parseInt(seq.substring(prevI, i)));
        prevI = i + 1;
      }
    }
    numbers.add(Integer.parseInt(seq.substring(prevI)));
  }
  public static int getSmallestValue() {
    int smallest = numbers.get(0);
    int index = 0;
    for (int i = 0; i < numbers.size(); i++) {
      if (numbers.get(i) < smallest) {
        smallest = numbers.get(i);
        index = i;
      }
    }
    numbers.remove(index);
    return smallest;
  }
  public static String arrange() {
    int k = numbers.size();
    String arrangedSentence = "";
    for (int i = 0; i < k; i++) {
      arrangedSentence = arrangedSentence + getSmallestValue() + " ";
    }
    return arrangedSentence;

  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("This program will order all elements in a sequence from least to greatest.");
    System.out.println("Please enter a sequence of whole numbers separated by a space");
    String seq = scan.nextLine();
    getEach(seq);
    String arranged = arrange();
    System.out.println(arranged);
  }
}
