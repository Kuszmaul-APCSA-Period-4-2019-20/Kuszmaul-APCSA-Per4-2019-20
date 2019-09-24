package flag;
import java.awt.*;
import java.util.Arrays;

import javax.swing.JFrame;
//this is 100% a cow your eyes deceive you
//version 2


/**
 * 
 * @author 95023871
 *
 */
public class CowFrame extends JFrame {
	private final Color BISQUE = new Color(0xcdb79e);
	private final Color COWLEG = new Color(0xFFD39B);
	private final Color USBLUE = new Color(0xA3161);
	private final Color USRED = new Color(0xB31942);
	
	public CowFrame () {
		init();
	}
	
	public void init() {
		setSize(950, 600);
		setBackground(Color.WHITE);
		repaint();
	}
	
	public void paint(Graphics g) {
		
			
			var height = this.getHeight();
			var width = this.getWidth();
			
			
			//divisible by 13 calculation
			int flagheight = height;
			if (height%13>0) {
				flagheight = height-(height%13);
			}
			
			//this is sketch
			int flagwidth = (int)(flagheight*1.9);
			if (flagwidth%13>0) {
				flagwidth = flagwidth-(flagwidth%13);
			}
			
			
			if(width<flagwidth) {
				flagheight=(int)(width/1.9)-(width%13);
			}
			
			//still needs some work, flag is offset by the 30 pixels added, need to fix somehow
			if(height<50) {
				//flagheight=(int)(height/1.9)-(height%13);
				flagheight = 13;
				//if(height<13) {
				//	g.setColor(USBLUE);
				//	g.fillRect(0,  0, 100, 100);;
				//}
			}
			//if(height<20) {
			//	flagheight = 4;
			//}
			
			
			
			
			g.setColor(Color.WHITE);
			g.fillRect(0,  20, width, (int)(flagwidth)+30);
			
			g.setColor(USRED);
			for(int i=0; i<14; i+=2) {
				g.fillRect(0, (i*flagheight/13)+20, /*this is flagwidth*/(int)(flagheight*1.9), flagheight/13);
			}
			
			g.setColor(USBLUE);
			g.fillRect(0,  20, (int)(flagheight*0.76), flagheight*7/13);
	
			
			//drawStar(g, 100, 100, (int)((flagheight/1.9)*0.0616));
			
			for(int u=0; u<12; u++) {
				if(u%2>0) {
					//idk if the q for loop is actually nessecary but it works so I ain't touching it
					for(int q=0; q<11; q++) {
						for(int i=0; i<10; i+=2) {
							drawStar(g, (int)(0.063*flagheight+(0.063*flagheight*(u-1))), (int)(0.0542*flagheight+(0.0542*flagheight*i))+20, (int)((flagheight/1.9)*0.0616));
							//drawStar(g, (int)(0.063*flagheight), (int)(0.1084*flagheight*i), (int)((flagheight/1.9)*0.0616));
						}
					}
				}
				else {
					for(int n=0; n<5; n++) {
						for(int i=0; i<8; i+=2) {
							drawStar(g, (int)(0.126*flagheight+(0.126*flagheight*(n))), (int)(0.108*flagheight+(0.0542*flagheight*i))+20, (int)((flagheight/1.9)*0.0616));
							//drawStar(g, (int)(0.063*flagheight), (int)(0.1084*flagheight*i), (int)((flagheight/1.9)*0.0616));
						}
					}
				}
			}
			
			
			//drawStar(g, (int)(0.063), (int)(1), (int)((flagheight/1.9)*0.0616));
			//drawStar(g, (int)(0.063), (int)(0.0542), (int)((flagheight/1.9)*0.0616));
		
	}
	
	/**
	 * For drawing stars
	 * @param g
	 * @param x
	 * @param y
	 * @param radius
	 */
    void drawStar(Graphics g, int x, int y, int radius) {
        // Code from: https://codereview.stackexchange.com/questions/142979/drawing-a-star-in-awt
        g.setColor(Color.WHITE);
        double FACTOR = 2.63;
        double ALFA = 18 * Math.PI / 180;
        double BETA = 54 * Math.PI / 180;

        double[] X = {0,Math.cos(BETA)/FACTOR, Math.cos(ALFA ),
                Math.cos(ALFA )/FACTOR, Math.cos(BETA),0,
                -Math.cos(BETA),-Math.cos(ALFA)/FACTOR,
                -Math.cos(ALFA ),-Math.cos(BETA)/FACTOR,0};

        double[] Y = {-1,-Math.sin(BETA)/FACTOR, -Math.sin(ALFA ),
                Math.sin(ALFA )/FACTOR, Math.sin(BETA),1/FACTOR,
                Math.sin(BETA),Math.sin(ALFA )/FACTOR,
                -Math.sin(ALFA ),-Math.sin(BETA)/FACTOR,-1};

        int[] xCoordOfStar;
        int[] yCoordOfStar;

        xCoordOfStar= new int[X.length];
        yCoordOfStar= new int[Y.length];
        int i;
        for (i=0; i<X.length; i++){
            xCoordOfStar[i] = (int)(radius*X[i]+x);
            yCoordOfStar[i] = (int)(radius*Y[i]+y);
        }
        g.fillPolygon(xCoordOfStar, yCoordOfStar, X.length);
    }

}
