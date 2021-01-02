package Extra;
import java.util.regex.*;
import java.util.Scanner;
public class PigLatinRegex {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("What do you want to translate?");
    String str = scan.nextLine().toLowerCase();
    regexChecker("\\b([aeiou]\\w*)\\b|\\b([^\\s\\daeiou]\\w*?)([aeiou]\\w*)\\b|\\b([^\\saeiou]+)\\b", str);
  }
  public static void regexChecker(String regexExp, String stringCheck) {
    Pattern regexCheck = Pattern.compile(regexExp);
    Matcher regexMatch = regexCheck.matcher(stringCheck);
    while (regexMatch.find()) {
      stringCheck = regexMatch.replaceAll("$1way|$3$2ay|$4ay");
    }
    stringCheck = stringCheck.replaceAll("\\bway\\|(\\w+)\\|ay\\b", "$1");
    stringCheck = stringCheck.replaceAll("\\b(\\w+)\\|ay\\|ay\\b", "$1");
    stringCheck = stringCheck.replaceAll("\\bway\\|ay\\|(\\w+)\\b", "$1");
    System.out.println(stringCheck.substring(0, 1).toUpperCase() + stringCheck.substring(1));
  }
}
