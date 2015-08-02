import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.Scanner;

import prog.ProblemOne;
import prog.ProblemThree;
import prog.ProblemTwo;

/**
 * This is an exercise from CS 3401: Introduction to Data Structures This
 * exercise pertains to three types of Java Collections: LinkedHashSet, HashSet,
 * and TreeMap Problem 1: User inputs some String in two LinkedHashSets and
 * outputs info that shows a union, intersection and difference of the first set
 * to the second set. Problem 2: Given a .txt file containing numbers separated
 * by an empty space, find the highest number of occurrences and print those
 * integers. Problem 3: Given an array of text files containing info regarding
 * popular babynames listed by year and gender, create a user input program that
 * allows users to search for info.
 */
public class MainClass {

	// static scanner input for use
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		ProblemOne p1 = new ProblemOne();
		ProblemTwo p2 = new ProblemTwo();
		ProblemThree p3 = new ProblemThree();
		int input = 0;

		do {
			System.out
			.println("Select the number of the program you want to run or view more info or exit: ");
			System.out.println("1 - Problem One: LinkedHashSets");
			System.out.println("2 - Problem Two: HashSets");
			System.out.println("3 - Problem Three: TreeMaps");
			System.out.println("4 - More info...");
			System.out.println("5 - Exit");			
			try {
				input = in.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Input must be an integer!");
				in.next();
				continue;
			}

			switch (input) {
			case 1:
				p1.run();
				System.out.println();
				break;
			case 2:
				p2.run();
				System.out.println();
				break;
			case 3:
				p3.run();
				System.out.println();
				break;
			case 4:
				System.out
						.println("By: Edward Calderon (MorningOwl@GitHub) \nThis is an exercise from CS 3401: Introduction to Data Structures");
				System.out
						.println("This exercise pertains to three types of Java Collections: LinkedHashSet, HashSet, and TreeMap");
				System.out.println(p1.getDescription());
				System.out.println(p2.getDescription());
				System.out.println(p3.getDescription());
				System.out.println();
				break;
			case 5:
				System.out.println("Good bye!");
				break;
			default:
				break;
			}
		} while (input != 5);

	}
}
