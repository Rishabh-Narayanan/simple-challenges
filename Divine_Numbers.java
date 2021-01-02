package Challenges.Extra;
/*
 * Dev: Rishabh Narayanan
 * Written: Jun 16, 2020
 */
import java.util.Scanner;
class Divine_Numbers {
	public static void main(String[] args) {
		// Context: For a number A, if the number of perfect cubes less than A (and greater than 0) is a multiple of an input K, then A will be considered a divine number.
		// Problem: Take two inputs from the user: N and K, respectively. Now find the number of divine numbers in the range of [1, N].
		// Challenge (Bonus Points, will look really good if you get it): Algorithm should perform in O(n) type or better.
		
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the maximum number (N): ");
		while (!scan.hasNextInt()) { // Edge case handling in case the user does not input a number
			scan.nextLine();
			System.out.println("Please enter a valid number");
		}
		int N = scan.nextInt();
		scan.nextLine();
		System.out.println("What is the divisor number (K): ");
		while (!scan.hasNextInt()) { // Edge case handling in case the user does not input a number
			scan.nextLine();
			System.out.println("Please enter a valid number");
		}
		int K = scan.nextInt();
		
		System.out.println("Your solution for (" + N + ", " + K + "): ");
		System.out.println(divineNumbers(N, K));
	}

	public static int divineNumbers(int N, int K) {
		if (K == 0) {  // This is to handle the edge case which would normally throw a divide by 0 error.
			return 0;
		}
		int currentCubeRoot = 1;    // This will keep track of the current cube we are at. All calculations will only occur at cube values
		int currentCube = (int) Math.pow(currentCubeRoot, 3);
		boolean flag = true;        // This will keep track of whether or not the previous value followed the rule of the being a multpile of K
		int count = 0;              // This will jsut keep track of the total number of divine numbers
		for (int i = 1; i <= N; i++) {  // I'm iterating through all values: Time complexity is O(N)
			if (flag) {          // If the previous value worked, then I know the current value will worked for the rule, so I increment count.
				count++;
			}
			if (currentCube == i) {  // When we reach cubes, then the rule can be broken, so here I check if we are at a cube
				if (currentCubeRoot % K == 0) {  // If the rule is maintained, I keep the flag as true
					flag = true;
				} else {     // Otherwise, I set the flag as false.
					flag = false;
				}
				currentCubeRoot++;   // At the end of this check, I know that there is one more cube number below so I update the vales
				currentCube = (int) Math.pow(currentCubeRoot, 3);
			}
		}
		return count;
	}
}