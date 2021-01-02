package Challenges.Extra;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class AmicableNumbers {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        AmicableNumbers a = new AmicableNumbers();
        int sumOfNumbers = 0;
        HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        long start = System.currentTimeMillis();
        for (int i = 2; i <= n; i++) {
            if (!map.containsValue(i)) {
                int N = a.sumProperFactors(i);
                if (N != i && N < n && a.sumProperFactors(N) == i) {
                    sumOfNumbers += N + i;
                    map.put(i, N);
                }
            }
        }
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("\nList of Amicable numbers:\n" + map);
        System.out.println("\nSum of Amicable numbers: " + sumOfNumbers);
        System.out.println("The program took " + elapsed + " milliseconds\n");
    }
    public int sumProperFactors(int number) {
        int count = number;
        int sum = 0;
        if (number == 0) return 0;
        for (int i = 1; i < count; i++) {
            if (number % i == 0) {
                sum += number / i;
                sum += i;
            }
            count = number / i;
        }
        if (count * count == number) {
            sum -= count;
        }
        return sum - number;
    }
}