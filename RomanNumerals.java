package Challenges.Extra;
// 1 = I, 5 = V, 10 = X, 50 = L, 100 = C, 500 = D, 1000 = M
public class RomanNumerals {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        RomanNumerals r = new RomanNumerals();
        System.out.println(r.romanNumerals(n));
    }
    public String romanNumerals(int n) {
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String s = "";
        int j = 0;
        while (n > 0) {
            int x = n / numbers[j];
            for (int i = 0; i < x; i++) {
                s += symbols[j];
                n -= numbers[j];
            }
            j += 1;
        }
        return s;
    }   
}