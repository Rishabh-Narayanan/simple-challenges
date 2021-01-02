package Challenges.Extra;

public class HarshadNumbers {
    public static void main(String[] args) {
        HarshadNumbers h = new HarshadNumbers();
        int n = Integer.parseInt(args[0]);
        int sum = 0;
        for (int i = 10; i < n; i++) {
            if (h.isStrongRight(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    public boolean isHarshad(int n) {
        String s = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        if (n % sum == 0) {
            return true;
        }
        return false;
    }
    public boolean isRight(int n) {
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            if (!isHarshad(n / (int) Math.pow(10, i))) {
                return false;
            }
        }
        return true;
    }
    public boolean isStrong(int n) {
        String s = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        if (isHarshad(n)) {
            if (isPrime(n / sum)) {
                return true;
            }
        }
        return false;
    }
    public boolean isStrongRight(int n) {
        int num = n / 10;
        if (isPrime(n)) {
            if (isStrong(num) && isRight(num)) {
                return true;
            }
        }
        return false;
    }
    public static boolean isPrime(int num) {
        if (num < 2) {
          return false;
        }
        int count = num;
        for (int i = 2; i < count; i++) {
          if (num % i == 0) {
            return false;
          }
            count = num / i;
        }
        return true;
      }
}