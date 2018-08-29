
import java.util.Arrays;
import java.util.Scanner;

/*
 * The captcha requires you to review a sequence of digits (your puzzle input)
 *  and find the sum of all digits that match the next digit in the list.
 *   The list is circular, so the digit after the last digit is the first 
 *   digit in the list.
 */


public class day1{
	public int getSum(String input) {
		String[] numbers = input.split("");
		int sum = 0;
		int[] number = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();
		int n = number.length;
		
		for(int i = 0; i < n; i++){
			if(i != n - 1 && number[i] == number[i+1] ) {
				sum = sum + number[i];
			}
			if(i == n-1 && number[0] == number[n-1])
				sum = sum + number[0];
		}
		return sum;
	}

	public int getSum2(String input) {
		String input1 = input.substring(0, input.length() / 2);
		String input2 = input.substring(input.length() / 2);
		int sum = 0;

		for(int i = 0; i < input1.length(); i++) {
			 String a = input1.substring(i, i + 1);
			 String b = input2.substring(i, i + 1);

			 int number1 = Integer.parseInt(a);
			 int number2 = Integer.parseInt(b);
		
			 if(number1 == number2) {
				 sum += number1*2;
			 }
		} 
		return sum;
	}
}
