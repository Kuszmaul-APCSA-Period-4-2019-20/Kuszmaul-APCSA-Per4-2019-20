package programmingContest.java;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
/**
 * @author ethan
 */
public class Main {
	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
		long startTime = System.nanoTime();
		
		// pass the path as a parameter 
		// [READ] file path to testcase needed here NEED CHANGE
			// if user is using WINDOWS, all slashes must be doubled as in the following example: "C:\\Users\\Kuszmaul\\Desktop\\Student_tears\\testcases\\p1.txt"
			// if user is using MAC, all slashes must be "/" as in the following example: "/Users/Kuszmaul/Desktop/Student_hell/testcases/p1.txt"
	    File file = new File("/Users/95023871/Desktop/Competition_Test_Cases/p7.txt"); 
	    Scanner sc = new Scanner(file); 
	    int array1size = Integer.parseInt(sc.nextLine());
	    int array1[] = new int[array1size]; 
		for(int i = 0; i<array1size; i++) {
			array1[i] = Integer.parseInt(sc.nextLine());
		}

		int array2size = Integer.parseInt(sc.nextLine());
	    int array2[][] = new int[array2size][2]; 
		for(int i = 0; i<array2size; i++) {
			array2[i][0] = sc.nextInt();
			array2[i][1] = sc.nextInt();
		}
		
		// [WRITE] file path here NEED CHANGE
			// if user is using WINDOWS, all slashes must be doubled as in the following example: "C:\\Users\\Kuszmaul\\Desktop\\Student_tears\\testcases\\p1.txt"
			// if user is using MAC, all slashes must be "/" as in the following example: "/Users/Kuszmaul/Desktop/Student_hell/testcases/p1.txt"
		PrintWriter writer = new PrintWriter("/Users/95023871/Desktop/Competition_Test_Cases/0.txt", "UTF-8");
		int position1 = 0;
		int position2 = 0;
		int sum = 0;
		for(int i = 0; i<array2size; i++) {
			
			//-1'ed because of input format
			position1 = array2[i][0] - 1;
			
			//next one is not -1'ed so that it includes the last index
			position2 = array2[i][1];
			
			//adder
			for(int j = position1; j<position2; j++) {
				sum += array1[j];
			}
			
			writer.println(String.format("%.3f", (double)sum/(position2-position1)));
			
			//reset sum for next iteration
			sum = 0;
		}
		writer.close();
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		System.out.println("done");
	}
}
