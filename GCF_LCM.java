package Challenges.Extra;

import java.util.Scanner;

public class GCF_LCM {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This program will calculate the least common multiple and " + 
        "the greatest common factor between two numbers, n1 and n2.");

        System.out.println("What is n1?");
        int n1 = scan.nextInt();
        System.out.println("What is n2?");
        int n2 = scan.nextInt();


        System.out.println("LCM: " + LCM(n1, n2));
        System.out.println("GCF: " + GCF(n1, n2));

    }

    private static int GCF(int n1, int n2) {
        int [] n1PF = Factors.getFactors(n1);
        int [] n2PF = Factors.getFactors(n2);
        int l1 = n1PF.length;
        int l2 = n2PF.length;
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                if (n1PF[i] > n2PF[j])
                    break;

                if (n1PF[i] == n2PF[j])
                    return n1PF[i];
            }
        }

       return 1;
    }

    private static int LCM(int n1, int n2) {
        return n1 * n2 / GCF(n1, n2);
    }
}