package prog;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

//Edward Calderon

public class ProblemTwo {
	private ArrayList<Integer> listOfIntegers;
	private int highestFreq;
	private HashSet<Integer> unique;

	public ProblemTwo() {
		// First read all of the integers and store in ArrayList
		listOfIntegers = readTextFile("txt/numerals.txt");
		// set the freq tracker at 0
		highestFreq = 0;
		// create a hashset with unique values
		unique = new HashSet<Integer>(listOfIntegers);
	}

	/**
	 * Runs Program Two
	 */
	public void run() {
		System.out.println("Problem Two running...\n");

		//go through list and check for the highest number of occurrences using Collections.frequency(Array, int) 
		//by going through each unique integer and compare their frequencies 
		System.out.print("Integer: Occurences\n");
		int freq = 0;
		for (Integer i : unique) {
			freq = Collections.frequency(listOfIntegers, i);
			//print
			System.out.println(i + ": " + freq);
			//check if current freq is higher than recorded highest
			if (highestFreq < freq) {
				//if so assign new high
				highestFreq = freq;
			}
		}

		System.out.println();
		System.out.println("The most occured integer(s) are:");
		//print the integers with said highest number of occurrences
		for (Integer i : unique) {
			if (highestFreq == Collections.frequency(listOfIntegers, i)) {
				System.out.println(i);
			}
		}
	}
	
	/**
	 * Gets a brief description of this program.
	 * @return info A String of text.
	 */
	public String getDescription(){
		return  "Problem 2: Given a .txt file containing numbers separated" +
				" by an empty space, find the highest number of occurrences and print those" +
				" integers.";
	}

	/**
	 * Reads the text file and stores in an ArrayList.
	 * @param name The name of the file.
	 * @return The list of integers in the file.
	 * @throws FileNotFoundException if file does not exits
	 * @throws IOException if file is not in correct format
	 */
	private ArrayList<Integer> readTextFile(String name) {
		ArrayList<Integer> list = new ArrayList<Integer>();

		FileInputStream fstream;
		try {
			fstream = new FileInputStream(name);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String str;
			while ((str = br.readLine()) != null) {
				String[] tokens = str.split(" ");
				for (int i = 0; i < tokens.length; i++) {
					list.add(Integer.parseInt(tokens[i]));
				}
			}
			fstream.close();
		} catch (FileNotFoundException e) {
			System.out.println(name + " file does not exist!");
		} catch (IOException e){
			System.out.println(name + " file is not in correct format!");
		}
		
		return list;
	}

}
