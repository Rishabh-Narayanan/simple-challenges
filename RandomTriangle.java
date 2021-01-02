package Challenges.Extra;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

public class RandomTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        System.out.println("How many iterations?");
        int iterations = scan.nextInt();
        System.out.println("Length of the line?");
        double l = scan.nextDouble();

        int count = 0;
        for (int i = 1; i <= iterations; i++) {
            double x = r.nextDouble() * l;
            double y = r.nextDouble() * l;
            if (y > x) {
                boolean triangle = validTriangle(x, y - x, l - y, l);
                if (triangle) {
                    count++;
                }

                System.out.println(x + ", " + (y - x) + ", " + (l - y) + " : " + count + " / " + i + ((triangle) ? " --> Valid Triangle" : " --> Invalid Triangle"));
            } else {
                boolean triangle = validTriangle(y, x - y, l - x, l);
                if (triangle) {
                    count++;
                }

                System.out.println(y + ", " + (x - y) + ", " + (l - x) + " : " + count + " / " + i + ((triangle) ? " --> Valid Triangle" : " --> Invalid Triangle"));
            }
        }
        System.out.println((double) count / (double) iterations * 100 + "%");

    }
    public static boolean validTriangle(double a, double b, double c, double l) {
        
        if (a < l / 2 && b < l / 2 && c < l / 2) return true;
        return false;
    }
}