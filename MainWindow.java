import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

import javax.swing.*;

public class MainWindow extends JFrame
{
	//variables
	private final int WINDOW_WIDTH = 600;
	private final int WINDOW_HEIGHT = 200;
	private JPanel panel1, panel2, panel3, panel4;
	private JButton button1, button2, button3, button4, button5, button6, button7, button8;
	private JLabel office1, office2, blank, blank2;
	private int numberOfBallots = Ballot.getNumberOfBallots();
	private int ballotRows = Ballot.getBallotRows();
	private Object officeID;
	private Object candidate;
	
	/**
	 * Constructor
	 * @param numberOfBallots 
	 * @param ballotRows 
	 */
	public MainWindow(int numberOfBallots, int ballotRows)
	{
		//sets title bar
		setTitle("Main Window");
		
		//sets window size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//specify an action for close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add GridLayout manager to content pane 1 row, 3 columns
		setLayout(new FlowLayout());
		
		//builds the panel
		int t = numberOfBallots;
		System.out.println("Before first panel stats: ballotRows " + ballotRows + " numberOfBallots " + numberOfBallots);
		
		buildFirstPanel(ballotRows, numberOfBallots);
		
		//adds the panel to the pane
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		
		//displays window
		setVisible(true);
	}

	public MainWindow(int numberOfBallots, int ballotRows, int voterID, int ballotID, String[][] candidate2)
	{
		// after login
		//sets title bar
				setTitle("Main Window");
				
				//sets window size
				setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
				
				//specify an action for close button
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				//add GridLayout manager to content pane 1 row, 3 columns
				setLayout(new FlowLayout());
				
				System.out.println("Before second panel stats: ballotRows " + ballotRows + " numberOfBallots " + numberOfBallots);
				
				
				
				//builds the panel
				int t = numberOfBallots;
				buildSecondPanel(ballotRows, numberOfBallots, officeID, candidate);
				
				
				
				
				
				
				//adds the panel to the pane
				add(panel1);
				//add(panel2);
				add(panel3);
				add(panel4);
				
				//displays window
				setVisible(true);
		
		
		
		
	}

	private void buildSecondPanel(int ballotRows, int numberOfBallots, Object officeID, Object candidate)
	{
		// TODO Auto-generated method stub
		
		//office1 = new JLabel("Office 1");
		//office2 = new JLabel("Office 2");
		
		blank = new JLabel();
		blank2 = new JLabel();
		button3 = new JButton("Cand #1");
		button3.addActionListener(new VoteListener());
		
		
		
		JLabel[] jLabels = new JLabel[numberOfBallots];
		//loop thru JLabels for each office
		for (int index=0; index<numberOfBallots; index++)
 		{
 			jLabels[index] = new JLabel("Office# " + index);
 			//panel1.add(jLabels[i]);
 			System.out.println(jLabels.length);
 		}
		
		//loop to create button
		JButton[] JButtons = new JButton[(ballotRows* numberOfBallots)];
		ButtonGroup group = new ButtonGroup();
		for (int i=0; i<JButtons.length; i++)
			
 		{
			JButtons[i] = new JButton("Cand # " + i);
 			//panel1.add(jLabels[i]);
			
			System.out.println(JButtons.length);
 		}
		
		
		System.out.println("Second panel stats: ballotRows " + ballotRows + " numberOfBallots " + numberOfBallots);
		
		
		
		
		
		button4 = new JButton("Cand #20");
		button4.addActionListener(new VoteListener());
		button5 = new JButton("Cand #30");
		button5.addActionListener(new VoteListener());
		button6 = new JButton("Cand #40");
		button6.addActionListener(new VoteListener());
		button7 = new JButton("Cand #50");
		button7.addActionListener(new VoteListener());
		button8 = new JButton("Cand #60");
		button8.addActionListener(new VoteListener());
		button1 = new JButton("Log In to Vote");
		
		
		
		//cast your vote
		button2 = new JButton("Cast your vote");
		button2.addActionListener(new CastListener());
		
		
		panel1 = new JPanel(new GridLayout((ballotRows+2),numberOfBallots));
		//panel2 = new JPanel(new GridLayout(4,1));
		panel3 = new JPanel(new GridLayout(3,1));
		panel4 = new JPanel(new GridLayout(3,1));
		button1.addActionListener(new LogInListener());
		
		
		panel1.setBackground(Color.RED);
		//panel2.setBackground(Color.CYAN);
		panel3.setBackground(Color.GREEN);
		panel4.setBackground(Color.ORANGE);
		
		//for loop to add labels
		for (int i=0; i<jLabels.length; i++)
 		{
 			//jLabels[i] = new JLabel("Office " + i);
			
			panel1.add(jLabels[i]);
			for (int j=0; j<JButtons.length; j++)
			{
				//group.add(JButtons[col]);
				
				panel1.add(JButtons[j], BorderLayout.SOUTH);
				System.out.println(i + " + " + j);
			}
 			
 			
 		}
		
		
		
		
		
		/**for loop to add buttons
		for (int i=0; i<3; i++)
		{
		 			//jLabels[i] = new JLabel("Office " + i);
			panel1.add(JButtons[i], BorderLayout.SOUTH);
		}*/
		
		//panel1.add(office1);
		//panel1.add(button3, BorderLayout.SOUTH);
		//panel1.add(button5, BorderLayout.SOUTH);
		//panel1.add(button7, BorderLayout.SOUTH);
		//panel1.add(office2);
		//panel1.add(button4, BorderLayout.SOUTH);
		//panel1.add(button6, BorderLayout.SOUTH);
		//panel1.add(button8, BorderLayout.SOUTH);
		panel3.add(blank);
		panel4.add(blank2);
		panel3.add(button1, BorderLayout.SOUTH);
		panel4.add(button2, BorderLayout.SOUTH);
		
		
		
		
		
		
		//after initial setting and logged in
		button1.setEnabled(false);
		
		
		
	}

	private void buildFirstPanel(int ballotRows,int numberOfBallots)
	{
		/**
		for (int row=0; row<tokens.length; row++)
        {
            for (int col=0; col<tokens[row].length; col++)
            {
               
            }
        }
		
		List<JPanel> panelList = new ArrayList<JPanel>();

		// add your JPanel object like this way
		panelList.add(yourPanel);

		// retrieve your JPanel object from list
		JPanel panel = panelList.get(index);
		*/
		
		
		System.out.println("First panel stats: ballotRows " + ballotRows + " numberOfBallots " + numberOfBallots);
		
		
		office1 = new JLabel("Office 1");
		office2 = new JLabel("Office 2");
		
		
		
		
		/**setup a for loop to create n number of offices
		GridLayout gridLayout = new GridLayout(ballotRows,numberOfBallots);
		JPanel ballotPanel = new JPanel(gridLayout);
		
		for ( int col = 0; col < numberOfButtons; col++ )
		{
			//create Panels for each office
			ballotPanel.add( new JPanel()
			 
			for ( int row = 0; row < numberOfButtons; row++ )
			{
				ballotPanel.add(new JButton(getCandidates(row, col)    ));
			}
		}
		*/
		
		
		
		
		
		
		
		blank = new JLabel();
		blank2 = new JLabel();
		button3 = new JButton("Cand #1");
		button4 = new JButton("Cand #2");
		button5 = new JButton("Cand #3");
		button6 = new JButton("Cand #4");
		button7 = new JButton("Cand #5");
		button8 = new JButton("Cand #6");
		button1 = new JButton("LogIn to Vote");
		button2 = new JButton("Cast your vote");
		panel1 = new JPanel(new GridLayout(4,1));
		panel2 = new JPanel(new GridLayout(4,1));
		panel3 = new JPanel(new GridLayout(3,1));
		panel4 = new JPanel(new GridLayout(3,1));
		button1.addActionListener(new LogInListener());
		
		
		panel1.setBackground(Color.RED);
		panel2.setBackground(Color.CYAN);
		panel3.setBackground(Color.GREEN);
		panel4.setBackground(Color.ORANGE);
		
		
		panel1.add(office1);
		panel1.add(button3, BorderLayout.SOUTH);
		panel1.add(button5, BorderLayout.SOUTH);
		panel1.add(button7, BorderLayout.SOUTH);
		panel2.add(office2);
		panel2.add(button4, BorderLayout.SOUTH);
		panel2.add(button6, BorderLayout.SOUTH);
		panel2.add(button8, BorderLayout.SOUTH);
		panel3.add(blank);
		panel4.add(blank2);
		panel3.add(button1, BorderLayout.SOUTH);
		panel4.add(button2, BorderLayout.SOUTH);
		
		
		
		//initial setting until logged in
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);
		button6.setEnabled(false);
		button7.setEnabled(false);
		button8.setEnabled(false);
	}
	
	
	
	
	private class LogInListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//System.exit(0);
			try
			{
				dispose();
				new VoterIDWindow();
			} catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	private class VoteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Component theEventer = (Component) e.getSource();
			
			
			if (theEventer == button3) 
			{
				button3.getModel().setSelected(true);
				button5.getModel().setSelected(false);
				button7.getModel().setSelected(false);
				//button3.getModel().setSelected(true);
				theEventer.setForeground(Color.red);
			}
			else if (theEventer == button5) 
			{
				button3.getModel().setSelected(false);
				button5.getModel().setSelected(true);
				button7.getModel().setSelected(false);
				//button5.getModel().setSelected(true);
				System.out.println("the button2 isSelected");
			}
			else if (theEventer == button7) 
			{
				button3.getModel().setSelected(false);
				button5.getModel().setSelected(false);
				//button7.getModel().setSelected(true);
				button7.getModel().setSelected(true);
                     
			}
			else if (theEventer == button4) 
			{
				button4.getModel().setPressed(true);
				theEventer.setForeground(Color.blue);  
			}
			else if (theEventer == button6) 
			{
				button6.getModel().setPressed(true);
                    
			}
			else if (theEventer == button8) 
			{
				button8.getModel().setPressed(true);
                     
			}
			
			
			
			// If event was generated by the JButton, do as we did
			// in ex13b -- change the color
			//if (theEventer == button3)
			//{
				
				//System.out.println("the button3 is pressed");
				//button3.getModel().setPressed(true);
				//theEventer.setForeground(Color.blue);
				//button3.getModel().setSelected(true);
			//}
			
			
			//if(button3.getModel().isSelected())
			//{
			//	System.out.println("the button3 isSelected");
				//button3.getModel().setPressed(false);
			//}
		//	else
				//System.out.println("the button3 is NOT Selected");
			
			
			// TODO Auto-generated method stub
			//button3.isSelected();
			//button3.setSelected(b);
		}
		
	}
	
	private class CastListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			JOptionPane.showMessageDialog(null, "Thanks Again.");
			
			
			//FileWriter fwriter = new FileWriter("firstTest.txt",true);
			try
			{
				PrintWriter outputFile = new PrintWriter("src/firstTest.txt");
				outputFile.println(getName());
				outputFile.close();
			} catch (FileNotFoundException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
			//will quit program after okay-ed
			System.exit(0);
		}
	}
	
}
