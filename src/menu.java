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
	private final static String newLine = "\n";
   	private JTextField field;
   	private JLabel label3; //arbitrary name, should fix it
    	private ForeignVocabQuiz quiz;
    	private String userGuess;
    	private String word;
    	private String counterPart;
  	private int totalQuestions;
    	private int questionsCorrect;
    	private int numOfGuesses;	

	
	 class Listener implements ActionListener {
	public void actionPerformed(ActionEvent event) {
	    userGuess = field.getText();
	    if(numOfGuesses < 3){
		if(quiz.checkUserGuess(userGuess))
		    label3.setText("Correct!");		
		else{
		    if (numOfGuesses == 2)
			label3.setText("The correct answer was: " + counterPart);
		    else
			label3.setText("False");
		    numOfGuesses++;
		}
	    }
	    field.requestFocus();
	    field.selectAll();
	}
    }

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
				quiz = new ForeignVocabQuiz(); 
				/*
				if(command.equals("german"))
				{
					quiz = new ForeignVocabQuiz(); 
				}
				if(command.equals("spanish"))
				{
					quiz = new ForeignVocabQuiz("spanish.txt");
				}
				if(command.equals("french"))
				{
					quiz = new ForeignVocabQuiz("french.txt");
				}
				*/
				frame2 = new JFrame("Foreign Vocab Quiz GUI");
				frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
				frame2.setLocationByPlatform(true);
				JTextArea text = new JTextArea(10,35);
				field = new JTextField(20);
				JLabel label = new JLabel("Your answer: ");
				JLabel label2 = new JLabel();
				label3 = new JLabel();
				JLabel label4 = new JLabel("Your score is " + questionsCorrect + "/" + totalQuestions + ".");
				JButton button = new JButton("answer");
				JPanel panel = new JPanel();
  				JPanel panel2 = new JPanel();
				JPanel panel3 = new JPanel();
				JScrollPane scroller = new JScrollPane(text);
				scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				text.setLineWrap(true);
				text.setEditable(false);
				text.append("Welcome!" + newLine);
				text.append("This is a vocabulary quiz for a foreign language." + newLine);
				text.append("You have three chances per word." + newLine);
				text.append("We'll begin now." + newLine);
				field.requestFocus();
				field.addActionListener(new Listener());
				button.addActionListener(new Listener());
				panel2.add(label2);
				panel.add(label);
				panel.add(field);
				panel.add(button);
				panel.add(label3);
				panel3.add(label4);
				panel3.add(scroller);
				frame2.getContentPane().add(BorderLayout.NORTH, panel2);
				frame2.getContentPane().add(BorderLayout.CENTER, panel);
				frame2.getContentPane().add(BorderLayout.SOUTH, panel3);
				frame2.setSize(450,300);
				frame2.setVisible(true);
				frame1.setVisible(false); 
				frame1.dispose();
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
