package stateupdaterbullshit;
import java.util.Scanner;

/*README-------------------------------
 * This program was created to calculate the distance traveled by an object between two different times.
 * It fulfills the spec by successfully calculating this value given some known values.
 * There are no current errors; any errors discovered will be corrected and a new version resubmitted.
 * This code has 3 helper methods, each for a kinematic equation; all other code is in the main method.
 * In the projectile motion method, there were some challenging moments, mainly getting the sqrt part to work;
 * once it did, there were no other major challenges.
 * Mr. Geller helped me by teaching me the fourmulas used in this program.
 */

/*USABLE TESTCASES---------------------
 * For VERTICAL MOTION: y0=0, yf=0, v0y=100, t1=0, t2=5.
 * OUTPUT: 375 meters.
 * 
 * For HORRIZONTAL MOTION: x0=0, xf=100, v0x=20, t1=1, t2=3.
 * OUTPUT: 40 meters.
 * 
 * For PROJECTILE MOTION: y0=10, yf=0, x0=0, theta=25, v0=30, t1=0, t2=3.
 * OUTPUT: 81.57 meters.
 */

public class main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		//getting user's choice of proj motion
	    System.out.println("Which kind of motion (vertical, horrizontal, projectile)?: ");
	    String type = scanner.nextLine();
	    //scanner.nextLine();
	    System.out.println("You have chosen: "+type+".");
	    
	    //got lazy didn't want more loops
	    //pointing user to different input possibilities
	    if(type.equals("vertical")) {
	    	//System.out.println("working");
	    	System.out.println("y0? ");
	    	double y0 = scanner.nextDouble();
	    	System.out.println("yf? ");
	    	double yf = scanner.nextDouble();
	    	System.out.println("v0y? ");
	    	double v0y = scanner.nextDouble();
	    	System.out.println("t1? ");
	    	double t1 = scanner.nextDouble();
	    	System.out.println("t2? ");
	    	double t2 = scanner.nextDouble();
	    	if(vertical(y0, yf, v0y, t1, t2) == -1) {
	    		System.out.println("The selected time is unusable.");
	    	}
	    	else {
	    		System.out.println("The ball has traveled "+vertical(y0, yf, v0y, t1, t2)+ " meters.");
	    	}
	    }
	    if(type.equals("horrizontal")) {
	    	//horrizontal(double x0, double xf, double v0x, double t1, double t2)
	    	System.out.println("x0? ");
	    	double x0 = scanner.nextDouble();
	    	System.out.println("xf? ");
	    	double xf = scanner.nextDouble();
	    	System.out.println("v0x? ");
	    	double v0x = scanner.nextDouble();
	    	System.out.println("t1? ");
	    	double t1 = scanner.nextDouble();
	    	System.out.println("t2? ");
	    	double t2 = scanner.nextDouble();
	    	if(horrizontal(x0, xf, v0x, t1, t2) == -1) {
	    		System.out.println("The selected time is unusable.");
	    	}
	    	else {
	    		System.out.println("The ball has traveled "+horrizontal(x0, xf, v0x, t1, t2)+ " meters.");
	    	}
	    }
	    if(type.equals("projectile")) {
	    	//double y0, double yf, double x0, double theta, double v0, double t1, double t2
	    	System.out.println("y0? ");
	    	double y0 = scanner.nextDouble();
	    	System.out.println("yf? ");
	    	double yf = scanner.nextDouble();
	    	System.out.println("x0? ");
	    	double x0 = scanner.nextDouble();
	    	System.out.println("theta? ");
	    	double theta = scanner.nextDouble();
	    	System.out.println("v0? ");
	    	double v0 = scanner.nextDouble();
	    	System.out.println("t1? ");
	    	double t1 = scanner.nextDouble();
	    	System.out.println("t2? ");
	    	double t2 = scanner.nextDouble();
	    	if(proj(y0,yf,x0,theta,v0,t1,t2) == -1) {
	    		System.out.println("The selected time is unusable.");
	    	}
	    	else {
	    		System.out.println("The ball has traveled "+proj(y0,yf,x0,theta,v0,t1,t2)+" meters.");
	    	}
	    }
	    if(type.equals("vertical")==false&&type.equals("horrizontal")==false&&type.contentEquals("projectile")==false) {
	    	System.out.println("Your choice was unusable.");
	    	main(args);
	    }
	    main(args);
	    
	    //position needed to add
	//    System.out.println(vertical(0, 0, 200, 1, 2));
	//    System.out.println(horrizontal(0, 100, 10, 1, 2));
	//	  System.out.println(proj(10, 0, 0, 25, 30, 0, 3.167185));
		//proj(double y0, double yf, double x0, double theta, double v0, double t1, double t2)
		
	}
	
	
	/**
	 * @param y0 = initial y pos
	 * @param yf = final y pos
	 * @param v0y = initial velocity y
	 * @param t1 = first time compare
	 * @param t2 = second time compare
	 * @return = distance traveled by object in between time compares
	 */
	public static double vertical(double y0, double yf, double v0y, double t1, double t2) {
		double t = Math.abs((v0y+Math.sqrt(v0y*v0y-4*(5*(yf-y0))))/10);
		
		//THIS IS FOR DEBUGGING System.out.println("Vertical t = " + t);
		
		if(t<t2) {
			return -1;
		}
		if(t1>t2) {
			return -1;
		}
		
		double temp1 = y0+v0y*t1-5*(t1*t1);
		double temp2 = y0+v0y*t2-5*(t2*t2);
		
		return temp2-temp1;
	}
	
	/**
	 * @param x0 = initial x pos
	 * @param xf = final x pos
	 * @param v0x = initial velocity x
	 * @param t1 = first time compare
	 * @param t2 = second time compare
	 * @return = distance traveled by object in between time compares
	 */
	public static double horrizontal(double x0, double xf, double v0x, double t1, double t2) {
		double t;
		t=Math.abs((xf-x0)/v0x);
		
		//THIS IS FOR DEBUGGING System.out.println("Horrizontal t = " + t);
		
		if(t<t2) {
			return -1;
		}
		if(t1>t2) {
			return -1;
		}
		
		double temp1 = x0+v0x*t1;
		double temp2 = x0+v0x*t2;
		
		return temp2-temp1;
	}
	
	/**
	 * @param y0 = initial y pos
	 * @param yf = final y pos
	 * @param x0 = initial x pos
	 * @param theta = angle of launch
	 * @param v0 = initial angled velocity
	 * @param t1 = first time compare
	 * @param t2 = second time compare
	 * @return = distance traveled by object in between time compares
	 */
	public static double proj(double y0, double yf, double x0, double theta, double v0, double t1, double t2) {
		double v0x = v0*Math.cos(Math.toRadians(theta));
		double v0y = v0*Math.sin(Math.toRadians(theta));
		//System.out.println(Math.sin(Math.toRadians(theta)));
		
		//THIS IS FOR DEBUGGING System.out.println("v0y: "+v0y);
		
		double t = Math.abs((v0y+Math.sqrt(v0y*v0y-4*(5*(yf-y0))))/10);
		
		/*THIS IS FOR DEBUGGING*/ System.out.println("Proj t: "+ t);
		
		if(t<t2) {
			return -1;
		}
		if(t1>t2) {
			return -1;
		}
		
		double xf1 = x0+v0x*t1;
		double xf2 = x0+v0x*t2;
		
		return xf2-xf1;
	}
	
}
