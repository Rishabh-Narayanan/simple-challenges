package Challenges.Extra;
import java.util.ArrayList;
import java.util.Arrays;
public class CircularPrimes {
    public static void main(String[] args) {
        CircularPrimes c = new CircularPrimes();
        int n = Integer.parseInt(args[0]);
        int count = 0;
        long start = System.currentTimeMillis();
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (c.circularPrime(i)) {
                count++;
                numbers.add(i);
            }
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("There are " + count + " circular numbers");
        System.out.println(Arrays.toString(numbers.toArray()));
        System.out.println("Took " + elapsed + " milliseconds");
    }
    public boolean circularPrime(int n) {
        int len = String.valueOf(n).length();
        String num = String.valueOf(n);
        for (int i = 0; i < len; i++) {
            if (prime(Integer.parseInt(num))) {

                num = rotateNumber(num);
            } else {
                return false;
            }
        }
        return true;
    }
    public String rotateNumber(String t) {
        t = t.substring(1) + Character.toString(t.charAt(0));
        return t;
    }
    public boolean prime(int num) {
        int n = num;
        for (int i = 2; i < n; i++) {
            if (num % i == 0) {
                return false;
            }
            n = num / i;
        }
        return true;
    }
}