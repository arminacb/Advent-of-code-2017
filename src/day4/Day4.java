package day4;
import java.util.Arrays;
import utils.file;
public class Day4 {
	
	public static void main(String[] args) throws Exception {
		part1();
		part2();
	}
	
	public static void part1() throws Exception {
		String[] finalInput = file.fileUtils(4);
		int counter = 0;
		
		int l = finalInput.length;
		
		for(int i = 0; i < l; i++) {
			boolean hasDuplicates = false;
			String currentLine = finalInput[i];
			String[] lineElements = currentLine.split("\\s");
			
			int l2 = lineElements.length;
			
			for(int j = 0; j < l2; j++) {
				for(int k = j+1; k < l2; k++) {
					
					if(j!=k) {
						if(lineElements[j].compareTo(lineElements[k]) == 0) {
							hasDuplicates = true;
							break;
						}
					}
				}
				if(hasDuplicates == true)
					break;
	
			}
			if(hasDuplicates == true)
				counter++;
			

			
		}
		System.out.println(l - counter );
			
	}
	
	public static void part2() {
		String[] input = file.fileUtils(4);
		int counter = 0;
		int l = input.length;

		for(String line : input) {
			boolean areAnagrams = false;
			String[] elementArray = line.split("\\s");
			int lenght = elementArray.length;
			for(int i = 0; i < lenght; i++) {
				for(int j = i; j < lenght; j++) {
					if(j!=i) {
						areAnagrams =  Arrays.equals(elementArray[i].chars().sorted().toArray(),
								elementArray[j].chars().sorted().toArray());
					}
					if(areAnagrams == true)
						break;
				}
				if(areAnagrams == true) {
					counter++;
					break;
				}
			}

		}
		
		System.out.println(l - counter );
			
	}
	



}
