package Challenges.Extra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.lang.Thread;

public class EmptyChairsOptimized {
    private int[] chairs;
    private ArrayList<Integer> validIndex;
    public static volatile double avg = 0;

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int numThreads = Integer.parseInt(args[2]);
        long start = System.nanoTime();
        multiThread[] e = new multiThread[numThreads];
        for (int i = 0; i < numThreads; i++) {
            e[i] = new multiThread(n, trials / numThreads);
            e[i].start();
        }
        for (int i = 0; i < numThreads; i++) {
            try {
                e[i].join();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        
        System.out.println(avg / trials);
        long elapsed = System.nanoTime() - start;
        System.out.println("Took " + elapsed / 1000000.0 + " milliseconds");
    }

    public static class multiThread extends Thread {
        public int N;
        public int iterations;
        public multiThread(int n, int t) {
            N = n;
            iterations = t;
        }
        @Override
        public void run() {
            // System.out.println("Executing...");
            // System.out.println(iterations);
            for (int i = 0; i < iterations; i++) { 
                EmptyChairsOptimized e = new EmptyChairsOptimized();
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
            //System.out.println("Terminated...");
        }
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