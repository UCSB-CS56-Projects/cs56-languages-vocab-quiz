import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A menu GUI to select which language to use for ForeignVocabQuiz.
 * @author Dan Luo
 * @version W15 cs56
 * @see ForeignVocabQuiz
 * */

public class menu
{
	private JFrame frame1, frame2; 
	private ActionListener action; 
	private JButton spanish, french, german; 
public void createAndDisplayGUI()
	{
		frame1 = new JFrame("Menu GUI"); 
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLocationByPlatform(true); 

		spanish = new JButton("spanish");
		french = new JButton("french");
		german = new JButton("german");
		spanish.setActionCommand("spanish");
		french.setActionCommand("french");
		german.setActionCommand("german"); 
		JPanel languagepanel = new JPanel(); 
		languagepanel.add(spanish);
		languagepanel.add(french);
		languagepanel.add(german);
		frame1.add(languagepanel);
		frame1.setSize(450,300); 
		frame1.setVisible(true); 
		action = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String command = e.getActionCommand(); 
				if(command.equals("german"))
				{
					ForeignVocabQuizGUI gui =  new ForeignVocabQuizGUI(); 
					gui.go(); 
				}
				if(command.equals("spanish"))
				{
					ForeignVocabQuizGUI gui = new ForeignVocabQuizGUI("spanish.txt");
					gui.go();
				}
				if(command.equals("french"))
				{
					ForeignVocabQuizGUI gui = new ForeignVocabQuizGUI("french.txt");
					gui.go();
				}
                	

             
			} 
		};
	german.addActionListener(action);
	french.addActionListener(action);
	spanish.addActionListener(action);
	
}
				
	public static void main(String [] args){
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				new menu().createAndDisplayGUI();
			}
		});
	}

} //end class 
