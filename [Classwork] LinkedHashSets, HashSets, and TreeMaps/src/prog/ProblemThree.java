package prog;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.List;

//Edward Calderon

public class ProblemThree {

	private TreeMap<String, Integer[]>[] boysList;
	private TreeMap<String, Integer[]>[] girlsList;
	private String[] textFiles;

	/**
	 * Runs Program Three
	 */
	public ProblemThree() {
		// Set up the map arrays and array of text files 10 elements
		boysList = new TreeMap[10];
		girlsList = new TreeMap[10];
		textFiles = new String[10];
	}

	public void run() {
		System.out.println("Problem Three running...\n");
		// Fill textFiles with file names
		textFiles[0] = "txt/babynamesranking2001.txt";
		textFiles[1] = "txt/babynamesranking2002.txt";
		textFiles[2] = "txt/babynamesranking2003.txt";
		textFiles[3] = "txt/babynamesranking2004.txt";
		textFiles[4] = "txt/babynamesranking2005.txt";
		textFiles[5] = "txt/babynamesranking2006.txt";
		textFiles[6] = "txt/babynamesranking2007.txt";
		textFiles[7] = "txt/babynamesranking2008.txt";
		textFiles[8] = "txt/babynamesranking2009.txt";
		textFiles[9] = "txt/babynamesranking2010.txt";

		// Fill arrays with TreeMaps
		for (int i = 0; i < 10; i++) {
			boysList[i] = new TreeMap<String, Integer[]>();
			girlsList[i] = new TreeMap<String, Integer[]>();
			storeEntries(boysList[i], girlsList[i], textFiles[i]);
		}

		// User Input
		boolean done = false;
		String doneResponse = "";
		do {
			Scanner in = new Scanner(System.in);
			int year = 0;
			String gender = "";
			String name = "";
			int ranking = 0;
			Integer[] values = new Integer[2];

			do {
				System.out.print("Please enter a Year (2001 - 2010): ");
				try {
					year = in.nextInt() - 2000;
				} catch (Exception e) {
					System.out.println(e);
					in.next();
					continue;
				}
			} while (!(1 <= year && year <= 10));
			do {
				System.out.print("Boy or Girl: ");
				gender = in.next();
				gender = gender.toLowerCase().trim();
			} while (!(gender.equals("boy") || gender.equals("girl")));
			System.out.print("Name: ");
			name = in.next();
			name = name.trim();

			if (gender.equals("boy")) {
				values = boysList[year - 1].get(name);
			} else if (gender.equals("girl")) {
				values = girlsList[year - 1].get(name);
			}

			// Program Output
			System.out.println("Searching...");
			if (values == null) {
				System.out
						.println("The name does not exist with the given information.");
			} else {
				System.out.printf("%s %8s %12s\n", "Rank", "Name", "Frequency");
				System.out
						.printf("%03d %9s %12d\n", values[0], name, values[1]);
			}

			do {
				System.out.println("Done? (Y = Yes, N = No)");
				doneResponse = in.next();
				doneResponse = doneResponse.trim();
			} while (!(doneResponse.equals("Y") || doneResponse.equals("N")));

			if (doneResponse.equals("Y")) {
				done = true;
			} else {
				done = false;
			}

		} while (!done);
		System.out.println("Done.");

	}
	
	/**
	 * Gets a brief description of this program.
	 * @return info A String of text.
	 */
	public String getDescription(){
		return  "Problem 3: Given an array of text files containing info regarding" +
				" popular babynames listed by year and gender, create a user input program that" +
				" allows users to search for info.";
	}

	/**
	 * Reads text file and stores keys and values to given maps.
	 * 
	 * @param boysMap
	 *            a TreeMap that contains a string for a key and array of
	 *            Integer for values
	 * @param girlsMap
	 *            a TreeMap that contains a string for a key and array of
	 *            Integer for values
	 * @param fileName
	 *            The file name of the data to be read.
	 */
	private void storeEntries(TreeMap<String, Integer[]> boysMap,
			TreeMap<String, Integer[]> girlsMap, String fileName) {
		FileInputStream fstream;
		try {
			fstream = new FileInputStream(fileName);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			StringTokenizer data;
			String str, boyName, girlName;
			int rank, boyFreq, girlFreq;
			Integer[] boyValues;
			Integer[] girlValues;

			/*
			 * The pattern by line should be five values separated by space:
			 * rank, boyName, boyFreq, girlName, girlFreq
			 */
			while ((str = br.readLine()) != null) {
				str = str.trim();
				if (!str.equals("")) {
					// Reinstate some variables
					data = new StringTokenizer(str);
					boyValues = new Integer[2];
					girlValues = new Integer[2];
					// Assign tokens to respective data
					rank = Integer.parseInt(data.nextToken());
					boyName = data.nextToken();
					boyFreq = Integer.parseInt(data.nextToken());
					girlName = data.nextToken();
					girlFreq = Integer.parseInt(data.nextToken());
					// Assign data to array of values
					boyValues[0] = rank;
					boyValues[1] = boyFreq;
					girlValues[0] = rank;
					girlValues[1] = girlFreq;
					// Put name as key and array as value in map
					boysMap.put(boyName, boyValues);
					girlsMap.put(girlName, girlValues);
				}
			}
			// close file stream
			fstream.close();
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " file does not exist!");
		} catch (IOException e) {
			System.out.println(fileName + " file is not in correct format!");
		}

	}
}
