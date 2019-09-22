import java.util.Scanner;

/*README-------------------------------
 * This program was created to find text within parenthesis and replace text as needed.
 * It fulfills the spec by successfully accomplishing these two tasks with user input.
 * There are no current errors; any errors discovered will be corrected and a new version resubmitted.
 * This code has two helper methods, each for one of the tasks. All user input is contained within main.
 * There were no challenging parts of this task; I used the internet to look up documentation on some of the used java methods.
 */

/*USABLE TESTCASES---------------------
 * For EXTRACTING: Hello there, (General) (Kenobi)!
 * OUTPUT: The text inside the first parenthesis was: General
 * 
 * For REPLACING: Master: Hello there, General Kenobi! | To be replaced: General | To replace with: Commodore
 * OUTPUT: Your new string is: Hello there, Commodore Kenobi!
 */

public class main_substring {

	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Do you want to extract first parenthesis or replace text? (extract|replace): ");
		String type = scanner.nextLine();
		System.out.println("You have chosen: " + type);
		if(type.equals("extract")) {
			System.out.println("Input string? ");
			String next = scanner.nextLine();
			System.out.println(extractFirstParen(next));
		}
		if(type.equals("replace")) {
			System.out.println("WARNING: CASE SENSITIVE.");
			System.out.println("Master string? ");
			String a = scanner.nextLine();
			System.out.println("String to be replaced? ");
			String b = scanner.nextLine();
			System.out.println("String to replace with? ");
			String c = scanner.nextLine();
			System.out.println(substituteAll(a, b, c));
		}
		if(type.equals("extract")==false&&type.equals("replace")==false) {
			System.out.println("Your selection was unusuable.");
		}
		main(args);
		
		/*
		System.out.println(extractFirstParen("hello (bitchyyy) (there) kenobi (bitch)"));
		System.out.println(extractFirstParen("hello) (bitchyyy) (there) kenobi (bitch)"));
		System.out.println(" ");
		System.out.println(substituteAll("hello", "z", "jsghdf"));
		*/
	}
	
	/**
	 * @param a, sentence with ()
	 * @return stuff in ()
	 */
	public static String extractFirstParen(String a){
		int par1=0;
		int par2=1;
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i)=='(') {
				par1=i;
				break;
			}
		}
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i)==')') {
				par2=i;
				break;
			}
		}
		if(par1>par2) {
			//return("You done fucked up, boy.");
			return("You had a closing parenthesis before an opened one. Try again!");
		}
		/*
		if(par1==par2) {
			return("You had no parenthesis, dumbass! Try again.");
		}
		*/
		String b = a.substring(par1+1, par2);
		return ("The text inside the first parenthesis was: "+ b);
	}
	
	
	
	//---------------------------------------------------------------------------------------------
	// return a string equal to a, *except* that every occurrence of b in a is substituted for by c.
	/**
	 * 
	 * @param a - master sentence
	 * @param b - string to be replaced
	 * @param c - string to replace with
	 * @return - a with all instances of b replaced with c
	 */
	public static String substituteAll(String a, String b, String c){
		if(b.length()>a.length()) {
			//return("You done fucked up, girl.");
			return("Your string to be replaced was longer than the master string! Try again.");
		}

		if(a.contains(b)) {
			return("Your new string is: " + a.replaceAll(b, c));
		}
		else {
			//return("You done fucked up, girl.");
			return("Your master string didn't contain the string to be replaced.");
		}
		
	}
	
	
}
