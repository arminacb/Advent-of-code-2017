package day2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*The spreadsheet consists of rows of apparently-random numbers.
To make sure the recovery process is on the right track, 
they need you to calculate the spreadsheet's checksum.
For each row, determine the difference between the largest
value and the smallest value; the checksum is the sum of 
all of these differences.*/

public class day2 {

	public static void main(String[] args) {
		String input = "6046	6349	208	276	4643	1085	1539	4986	7006	5374	252	4751	226	6757	7495	2923\r\n" + 
				"1432	1538	1761	1658	104	826	806	109	939	886	1497	280	1412	127	1651	156\r\n" + 
				"244	1048	133	232	226	1072	883	1045	1130	252	1038	1022	471	70	1222	957\r\n" + 
				"87	172	93	73	67	192	249	239	155	23	189	106	55	174	181	116\r\n" + 
				"5871	204	6466	6437	5716	232	1513	7079	6140	268	350	6264	6420	3904	272	5565\r\n" + 
				"1093	838	90	1447	1224	744	1551	59	328	1575	1544	1360	71	1583	75	370\r\n" + 
				"213	166	7601	6261	247	210	4809	6201	6690	6816	7776	2522	5618	580	2236	3598\r\n" + 
				"92	168	96	132	196	157	116	94	253	128	60	167	192	156	76	148\r\n" + 
				"187	111	141	143	45	132	140	402	134	227	342	276	449	148	170	348\r\n" + 
				"1894	1298	1531	1354	1801	974	85	93	1712	130	1705	110	314	107	449	350\r\n" + 
				"1662	1529	784	1704	1187	83	422	146	147	1869	1941	110	525	1293	158	1752\r\n" + 
				"162	1135	3278	1149	3546	3686	182	149	119	1755	3656	2126	244	3347	157	865\r\n" + 
				"2049	6396	4111	6702	251	669	1491	245	210	4314	6265	694	5131	228	6195	6090\r\n" + 
				"458	448	324	235	69	79	94	78	515	68	380	64	440	508	503	452\r\n" + 
				"198	216	5700	4212	2370	143	5140	190	4934	539	5054	3707	6121	5211	549	2790\r\n" + 
				"3021	3407	218	1043	449	214	1594	3244	3097	286	114	223	1214	3102	257	3345";
		int part1 = checksum(input);
		int part2 = part2(input);
		
		System.out.printf("Part 1: %d\nPart 2: %d", part1, part2);
	}
	
	private static int checksum(String s) {
		int checksum = 0;
		String[] input = s.split("\r\n");
	

		for(String line : input) {
			String[] numbers = line.split("\t");
			List<Integer> i_numbers = new ArrayList<Integer>();
			
			for(String str : numbers)
				i_numbers.add(Integer.parseInt(str));
			
			int[] numberArray = i_numbers.stream().mapToInt(k->k).toArray();
		
        	int min = Arrays.stream(numberArray).min().getAsInt();
        	int max = Arrays.stream(numberArray).max().getAsInt();
        	int difference = max - min;    
        	checksum += difference;
        
		}
		return checksum;
	}
	
/*	It sounds like the goal is to find the only two
	numbers in each row where one evenly divides the other
	- that is, where the result of the division operation
	is a whole number. They would like you to find those
	numbers on each line, divide them, and add up each line's
	result.*/

	private static int part2(String s) {
		String[] input = s.split("\r\n");
		
		int total = 0;

		for(String line : input) {
			String[] numbers = line.split("\t");
			List<Integer> i_numbers = new ArrayList<Integer>();
			
			for(String str : numbers)
				i_numbers.add(Integer.parseInt(str));
			
			
			int[] numberArray = i_numbers.stream().mapToInt(k->k).toArray();
			Arrays.sort(numberArray);
			for(int i = 0; i < numberArray.length; i++) {
	        	int min = Arrays.stream(numberArray).min().getAsInt();
	        	int max = Arrays.stream(numberArray).max().getAsInt();
				
				
				for(int a = 2; a < max/min; a++) {
					int temp = numberArray[i];
					temp = temp * a;
				if(ContainsMethod(numberArray,temp)) {
					total += a;
					break;
				}
				}
					
				}
			}
		return total;
	}
	public static boolean ContainsMethod(int[] array, int value) {
		 
		for (int isMatched : array) {
			if (isMatched == value) {
				return true;
			}
		}
		return false;
	}
}

