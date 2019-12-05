package programmingContest.java;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author ethan
 *
 */
public class Main_copy_paste_needed {
	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException {
		
		System.out.println("Size of array 1: ");
		Scanner scanner = new Scanner(System.in);
		int array1size = scanner.nextInt();
		int array1[] = new int[array1size]; 
		for(int i = 0; i<array1size; i++) {
			array1[i] = scanner.nextInt();
		}
		
		//System.out.println(Arrays.toString(array1));

		System.out.println("Size of array 2: ");
		int array2size = scanner.nextInt();
		int array2[][] = new int[array2size][2]; 
		for(int i = 0; i<array2size; i++) {
			for(int j = 0; j<2; j++) {
				array2[i][j] = scanner.nextInt();
				if(array2[i][j] > array1.length) {
					System.out.println("that number is bigger than the size of array1!");
					System.exit(-1);
				}
			}
		}
		
		PrintWriter writer = new PrintWriter("/Users/95023871/Desktop/Competition_Test_Cases/0.txt", "UTF-8");
		
		//System.out.println(Arrays.deepToString(array2));
		long startTime = System.nanoTime();
		int position1 = 0;
		int position2 = 0;
		double sum = 0;
		double average = 0;
		for(int i = 0; i<array2size; i++) {
			
			//-1'ed because of input format
			position1 = array2[i][0] - 1;
			
			//next one is not -1'ed so that it includes the last index
			position2 = array2[i][1];
			
			//adder
			for(int j = position1; j<position2; j++) {
				//System.out.println(array1[j] + " current position");
				sum = sum + array1[j];
			}
			
			//System.out.println("Sum: " + sum);
			
			average = sum/(position2-position1);
			//System.out.println("Average: " + String.format("%.3f", average));
			writer.println(String.format("%.3f", (double)sum/(position2-position1)));
			
			//reset sum and average for next iteration
			sum = 0;
			average = 0;
		}
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime);
		
	}
}
