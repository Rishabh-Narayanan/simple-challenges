package Challenges.Extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class EmptyChairs {
    private int[] chairs;
    private ArrayList<Integer> validIndex;
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double avg = 0;
        int i;
        long start = System.currentTimeMillis();
        for (i = 0; i < trials; i++) {
            EmptyChairs e = new EmptyChairs();
            e.chairs = new int[N];
            e.validIndex = new ArrayList<Integer>();
            for (int j = 0; j < e.chairs.length; j++) {
                e.validIndex.add(j);
            }
            while(e.validIndex.size() != 0) {
                e.updateValid();
            }
            
            double count = 0;
            for (int j = 0; j < N; j++) {
                if (e.chairs[j] == 0) {
                    count++;
                }
            }
            avg += count / N;
        }
        System.out.println("Average Empty Chairs: " + (avg / i));
        long elapsed = System.currentTimeMillis() - start;
        System.out.println("Took " + elapsed + " milliseconds");
    }

    public void updateValid() {
        Random rand = new Random();
        int r = rand.nextInt(validIndex.size());
        chairs[validIndex.get(r)] = 1;
        if (validIndex.size() > 2) {
            if (r == 0) {
                removeFirst();
            } else if (r == validIndex.size() - 1) {
                removeLast();
            } else {
                removeMiddle(r);
            }
        } else {
            if (validIndex.size() == 2) {
                if (!(validIndex.get(0) == validIndex.get(1) - 1 || validIndex.get(0) == 0 && validIndex.get(1) == chairs.length - 1)) {
                    chairs[validIndex.get(0)] = 1;
                    chairs[validIndex.get(1)] = 1;
                }
                validIndex.remove(1);
                validIndex.remove(0);
            } else if (validIndex.size() == 1) {
                validIndex.remove(0);
            }
        }
    }
    public void removeFirst() {
        if (validIndex.get(0) == 0) {
            if (validIndex.get(validIndex.size() - 1) == chairs.length - 1) {
                validIndex.remove(validIndex.size() - 1);
            }
        }
        if (validIndex.get(1) == validIndex.get(0) + 1) {
            validIndex.remove(1);
        }
        validIndex.remove(0);
    }
    public void removeLast() {
        if (validIndex.get(validIndex.size() - 1) == chairs.length - 1) {
            if (validIndex.get(0) == 0) {
                validIndex.remove(0);
            }
        }
        if (validIndex.get(validIndex.size() - 2) == validIndex.get(validIndex.size() - 1) - 1) {
            validIndex.remove(validIndex.size() - 2);
        }
        validIndex.remove(validIndex.size() - 1);
    }
    public void removeMiddle(int r) {
        boolean b = true;
        if (validIndex.get(r + 1) == validIndex.get(r) + 1) {
            validIndex.remove(r + 1);
        }
        if (validIndex.get(r - 1) == validIndex.get(r) - 1) {
            validIndex.remove(r - 1);
            b = false;
            validIndex.remove(r - 1);
        }
        if (b) {
            validIndex.remove(r);
        }
    }
}