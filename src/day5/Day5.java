package day5;
import java.util.ArrayList;
import java.util.List;

import utils.file;

public class Day5 {

	public static void main(String[] args) {
		part1();
		part2();
	}
	
	private static void part1() {
		String[] input = file.fileUtils(5);
		List<Integer> steps = new ArrayList<Integer>();
		int counter = 0;
		for(String line: input) 
			steps.add(Integer.parseInt(line));

		int[] intArray = steps.stream().mapToInt(i->i).toArray();
		int lenght = intArray.length;
		for(int i = 0; i < lenght;) {
			int currentStep = intArray[i];
			int nextStep = i + currentStep;
			intArray[i]++;
			i = nextStep;
			counter++;
			if(i - lenght >= 0)
				break;
		}
		System.out.println(counter);
	}
	private static void part2() {
		String[] input = file.fileUtils(5);
		List<Integer> steps = new ArrayList<Integer>();
		int counter = 0;
		for(String line: input) 
			steps.add(Integer.parseInt(line));

		int[] intArray = steps.stream().mapToInt(i->i).toArray();
		int lenght = intArray.length;
		for(int i = 0; i < lenght;) {
			int currentStep = intArray[i];
			int nextStep = i + currentStep;
			if(intArray[i] >= 3)
				intArray[i]--;
			else
				intArray[i]++;
		
			i = nextStep;
			counter++;
			if(i - lenght >= 0)
				break;
		}
		System.out.println(counter);
	}
	
}
