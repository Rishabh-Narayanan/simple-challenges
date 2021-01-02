package Extra;

import java.util.Scanner;
public class PigLatin {
  private String word = "";
  private int index = 0;
  public void findVowel(String w) {
    word = w;
    int len = word.length();
    for (int i = 0; i <= len; i++) {
      if (i == len) {
        index = len;
      } else if (isVowel(word, i)) {
        index = i;
        break;
      } else {
        continue;
      }
    }
  }
  public boolean isVowel(String s, int i) {
    String letter = Character.toString(s.charAt(i));
    String[] vowels = {"e", "a", "o", "i", "u"};
    for (String k: vowels) {
      if(letter.equalsIgnoreCase(k) ) {
        return true;
      }
    }
    return false;
  }
  public String translateWord(String w) {
    findVowel(w);
    if (index == 0) {
      word += "way";
    } else if (index == word.length()) {
      word += "ay";
    } else {
      word = word.substring(index) + word.substring(0, index) + "ay";
    }
    return word;
  }
  public static String capitalizeCorrectly(String s) {
    s = s.toLowerCase();
    s = Character.toString(s.charAt(0)).toUpperCase() + s.substring(1);
    for (int i = 0; i < s.length() - 2; i++) {
      char l = s.charAt(i);
      if (l == '.' || l == '?' || l == '!' || l == ';') {
        s = s.substring(0, i + 2) + Character.toString(s.charAt(i + 2)).toUpperCase() + s.substring(i + 3);
      }
    }
    return s;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    PigLatin translate = new PigLatin();
    String[] words;
    int count = 0;
    System.out.println("What do you want to translate");
    String w = scan.nextLine();
    int numLetters = w.length();
    //  translate.translateWord(w);
    for (int j = 0; j < numLetters; j++) {
      if (w.charAt(j) == ' ') {
        count++;
      }
    }
    words = new String[count + 1];
    int start = 0;
    count = 0;
    int end;
    for (int j = 0; j < numLetters; j++) {
      if (w.charAt(j) == ' ') {
        end = j;
        words[count] = w.substring(start, end);
        start = end + 1;
        count++;
      }
    }
    words[count] = w.substring(start);
    String translatedSentence = "";
    String pigLatinWord;
    for (String j: words) {
      pigLatinWord = translate.translateWord(j);
      for (int k = 0; k < pigLatinWord.length(); k++) {
        char s = pigLatinWord.charAt(k);
        if (s == '.' || s == ',' || s == '?' || s == '!' || s == ';') {
          pigLatinWord = pigLatinWord.replace(Character.toString(s) , "");
          pigLatinWord += s;
        }
      }
      translatedSentence = translatedSentence + pigLatinWord + " ";
    }
    translatedSentence = capitalizeCorrectly(translatedSentence);
    System.out.println(translatedSentence);
  }
}
