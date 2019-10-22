package hivolts;
import java.awt.*;
public class Main {
//this is 100% a cow your eyes deceive you
//version 2

	public static void main(String[] args) {
		Board c = new Board();
		c.setDefaultCloseOperation(Board.EXIT_ON_CLOSE);
		c.setVisible(true);
		keylistener.main(args);
	}

}


/*package hivolts;
import javax.swing.*;
import java.awt.*;
//import flag.CowFrame;

public class Main {

   public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable()
       {
           @Override
           public void run()
           {
               createAndShowGUI();
           }
       });
       
       keylistener.main(null);

   }
   
   private static void createAndShowGUI()
   {
       JFrame f = new JFrame();
       f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       f.setSize(650, 650);
       f.getContentPane().add(new Board());
       f.setLocationRelativeTo(null);
       f.setVisible(true);
       f.getContentPane().getSize();
       
       
       //gameplay c = new gameplay();
       //c.setDefaultCloseOperation(gameplay.EXIT_ON_CLOSE);
       //c.setVisible(true);
       
       //keylistener d = new keylistener();
       //d.setDefaultCloseOperation(gameplay.EXIT_ON_CLOSE);
       
   }
}
*/
