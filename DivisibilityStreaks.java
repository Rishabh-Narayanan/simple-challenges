package Challenges.Extra;

import java.util.ArrayList;

public class DivisibilityStreaks {

    public static void main(String[] args) {
        int s = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        DivisibilityStreaks d = new DivisibilityStreaks();
        ArrayList<Integer> l = new ArrayList<Integer>();
        int count = 0;
        long start = System.nanoTime();

        for (int i = 2; i < n; i++) {
            // int j;
            // boolean b = true;
            // for (j = 1; j <= s; j++) {
            //     if ((i + j - 1) % j != 0) {
            //         b = false;
            //         break;
            //     }
            // }
            // if ((i + j - 1) % j != 0 && b) {
            //     count++;
            //     l.add(i);
            // }

            // if (d.streak1(i, s)) {
            //     count++;
            //     l.add(i);
            // }

            if (d.streak(i) == s) {
                count++;
                l.add(i);
            }
        }

        long elapsed = System.nanoTime() - start;
        System.out.println(l);
        System.out.println(count);
        System.out.println("Took " + elapsed / 1000000.0 + " milliseconds");
    }

    public int streak(int n) {
        int i;
        for (i = 1; i <= n; i++) {
            if ((n + i - 1) % i != 0) {
                break;
            }
        }
        return i - 1;
    }

    public boolean streak1(int i, int s) {
        int j;
        boolean b = true;
        for (j = 1; j <= s; j++) {
            if ((i + j - 1) % j != 0) {
                b = false;
                break;
            }
        }
        if ((i + j - 1) % j != 0 && b) {
            return true;
        }
        return false;
    }
}