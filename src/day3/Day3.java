package day3;

public class Day3 {

	public static void main(String[] args) {
		int input = 312051;
		int p1 = part1(input);
		System.out.println(p1);
		part2();
	}
	
	public static int part1(int input) {
		double c = Math.sqrt(input), stepsUp;
		c = Math.ceil(c);
		stepsUp = (c-1)/2; 
		
			

		double position = c * c - input;
		double stepsLeftOrRight =  Math.abs(position - stepsUp);

		return (int) (stepsUp + stepsLeftOrRight);
		
	}
	//Basically I want to generate the sequence in order to give a proper answer
	//So I looked it up and found this interesting site that I'm grateful exists: 
	//                       https://oeis.org/A128216
	//Enter 1 into center position of the spiral. Repeat:
/*	Go to next position of the spiral and enter into that position
	the sum of the numbers in those already filled positions that are horizontally,
	vertically or diagonally adjacent to it.

	Clockwise and counterclockwise construction of the spiral result in the same sequence. 
*/	
	
	public static void part2() {
		int[] a = new int[60];
		a[0] = 1;
		a[1] = 1;
		int lenght = a.length;
		
		for(int i = 1; i < lenght-1; i++) {
			a[i + 1] = a[i] + a[smallest_prime(i)];
		}
		
		for(int number : a)
			System.out.printf( " %d , ", number);

	}
	
	public static int smallest_prime(int n) {
		int[] first100primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541};

		int lenght = first100primes.length;
		for(int i = 0; i < lenght; i++) {
			if(n % first100primes[i] == 0)
				return first100primes[i];
			else
				return 1;
		}
		return 0;
	}
	
}
