package prog;
import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @author Edward Calderon This is an exercise from CS 3401: Introduction to
 *         Data Structures This exercise pertains to three types of Java
 *         Collections: LinkedHashSet, HashSet, and TreeMap Problem 1: User
 *         inputs some String in two LinkedHashSets and outputs info that shows
 *         a union, intersection and difference of the first set to the second
 *         set.
 */
public class ProblemOne {

	private LinkedHashSet<String> setOne;
	private LinkedHashSet<String> setTwo;
	private String input;
	private Scanner in = new Scanner(System.in);

	public ProblemOne() {
		// Initialize variables
		setOne = new LinkedHashSet<String>();
		setTwo = new LinkedHashSet<String>();
		input = "";

	}

	/**
	 * Runs Program One
	 */
	public void run() {
		System.out.println("Problem One running...\n");

		
		// Input
		System.out
				.println("Type a word to be added to Set One and press Enter to add. Type -1 to finish. ");
		while (!input.equals("-1")) {
			System.out.print("Set One, Word " + (setOne.size() + 1) + ": ");
			input = in.nextLine();
			if (!(input.isEmpty() || input.equals("-1"))) {
				setOne.add(input);
			}
		}

		input = "";
		System.out.println();
		System.out
				.println("Type a word to be added to Set Two and press Enter to add. Type -1 to finish. ");
		while (!input.equals("-1")) {
			System.out.print("Set Two, Word " + (setTwo.size() + 1) + ": ");
			input = in.nextLine();
			if (!(input.isEmpty() || input.equals("-1"))) {
				setTwo.add(input);
			}
		}

		// Clone setOne to retain original copy of data
		LinkedHashSet<String> cloneOne = (LinkedHashSet<String>) setOne.clone();
		LinkedHashSet<String> cloneTwo = (LinkedHashSet<String>) setOne.clone();
		LinkedHashSet<String> cloneThree = (LinkedHashSet<String>) setOne.clone();

		// Unionize the sets by appending setTwo to setOne (only unique elements
		// are added)
		cloneOne.addAll(setTwo);
		// Intersect sets by removing elements in setOne NOT found in setTwo
		cloneTwo.retainAll(setTwo);
		// Differentiate sets by removing elements in setOne found in setTwo
		cloneThree.removeAll(setTwo);

		// Output
		System.out.println();
		System.out.println("SetOne: " + setOne.toString());
		System.out.println("SetTwo: " + setTwo.toString());
		System.out
				.println("Union of SetOne to SetTwo : " + cloneOne.toString());
		System.out.println("Intersection of SetOne to SetTwo : "
				+ cloneTwo.toString());
		System.out.println("Difference of SetOne to SetTwo "
				+ cloneThree.toString());
	}

	/**
	 * Gets a brief description of this program.
	 * @return info A String of text.
	 */
	public String getDescription() {
		return "Problem 1: User inputs some String in two LinkedHashSets and outputs info that shows a union, intersection and difference of the first set to the second set.";
	}

}
