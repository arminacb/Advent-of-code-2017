package day3;

public class Day3 {

	public static void main(String[] args) {
		int input = 312051;
		int p1 = part1(input);
		System.out.println(p1);
	}
	
	public static int part1(int input) {
		double c = Math.sqrt(input), stepsUp;
		c = Math.ceil(c);
		stepsUp = (c-1)/2; 
		
			

		double position = c * c - input;
		double stepsLeftOrRight =  Math.abs(position - stepsUp);

		return (int) (stepsUp + stepsLeftOrRight);
		
	}
}
