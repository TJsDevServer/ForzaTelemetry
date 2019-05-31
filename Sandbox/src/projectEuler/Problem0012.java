package projectEuler;

import java.util.ArrayList;

/* The sequence of triangle numbers is generated by adding the natural numbers. 
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. The first ten terms would be:
 *
 *1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 *Let us list the factors of the first seven triangle numbers:
 *
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 * We can see that 28 is the first triangle number to have over five divisors.
 *  
 * What is the value of the first triangle number to have over five hundred divisors?
*/
public class Problem0012 {
	public static String problem0012() {
		int divisorTarget = 501;
		int currentTriangularNum = 0;
		int i = 1;
		int totalFactors = 0;

		while (true) {
			currentTriangularNum += i;
			i++;
			totalFactors = countFactors(currentTriangularNum);
			if (totalFactors >= divisorTarget)
				return "" + currentTriangularNum;
		}
	}

	public static int countFactors(int num) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int divisor = 2;

		while (num > 1) {
			if (num % divisor == 0) {
				num /= divisor;
				list.add(divisor);
			} else {
				divisor = divisor == 2 ? 3 : divisor + 2;
			}
		}

		int currDivisor = 1;
		int count = 0;
		int answer = 1;

		for (int i : list) {
			if (currDivisor != i) {
				answer *= count + 1;
				count = 1;

				currDivisor = i;
			} else {
				count++;
			}
		}
		answer *= count + 1;

		return answer;
	}
}