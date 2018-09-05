package utils;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class file {
	
	public static String[] fileUtils(int day) {
		
		File file = new File("F:\\Users\\armin\\GitHub\\AdventOfCode2017\\src\\utils\\inputs\\input"+day+".txt");
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> input = new ArrayList<String>();
		
		while (sc.hasNextLine())
			input.add(sc.nextLine());
		
		String[] finalInput = input.toArray(new String[0]);
		
		return finalInput;
	}

}
