import java.awt.GridLayout;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.*;

public class VoterIDWindow extends JFrame
{
	//variables
	private final int WINDOW_WIDTH = 300;
	private final int WINDOW_HEIGHT = 150;
	private JPanel panel1, panel2, panel3;
	private JLabel voterIDMessage;
	private JTextField idText;
	private JButton button1, button2;
	private Ballot voter;
	String voters = "src/voters.txt";
	private String[][] registeredVoters;
	private String[] VoterID;
	private String[] VoterName;
	private Boolean[] voted;
	private String[] voterID;
	private String[] voterName;
	private Boolean[] vote;
	
	/**
	 * Constructor
	 * @throws FileNotFoundException 
	 */
	public VoterIDWindow() throws FileNotFoundException
	{
		//sets title bar
		setTitle("Voter ID");
		
		//sets window size
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		//specify an action for close button
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//add GridLayout manager to content pane 3 rows, 1 column
		setLayout(new GridLayout(3,1));
		
		//builds the panel
		buildPanel();
		
		//adds the panel to the pane
		add(panel1);
		add(panel2);
		add(panel3);
		
		//displays window
		setVisible(true);
		
		//voter = new Ballot();
		
		//loads voters
		String voters = "src/voters.txt";
		System.out.println("filename entered is: " + voters);
		File file2 = new File(voters);
		Scanner inputFile2 = new Scanner(file2);
		ArrayList<String[]> voterList = new ArrayList<String[]>();
		while(inputFile2.hasNextLine())
	    {
	    	String tempVoter = inputFile2.nextLine();
	    	//splits tempVoter up by ':' and ','
		 	String[] voter = tempVoter.split("[\\:]+");
	        voterList.add(voter);
	    	
	    }
	    inputFile2.close();
	    
	    registeredVoters = new String[voterList.size()][voterList.get(0).length];
	    registeredVoters = voterList.toArray(registeredVoters);
	    
	  //just a blank line
        System.out.println();
        
        VoterID = new String[registeredVoters.length];
        VoterName = new String[registeredVoters.length];
        voted = new Boolean[registeredVoters.length];
        
        //test printout of all of the cells
        for (int row=0; row<registeredVoters.length; row++)
        {
        	//int tempInt = Integer.parseInt(registeredVoters[row][0]);
        	VoterID[row] = registeredVoters[row][0];;
        	System.out.println("VoterID[" + (row)+ "]" + VoterID[row]);
        	setVoterID(VoterID);
        	
        	VoterName[row] = registeredVoters[row][1];
        	System.out.println("VoterName[" + (row)+ "]" + VoterName[row]);
        	setVoterName(VoterName);
        	
        	voted[row] = Boolean.parseBoolean(registeredVoters[row][2]);
        	System.out.println("voted[" + (row)+ "]" + voted[row]);
        	setVote(voted);
        	
        }
		
		
        
        
        
        
        
        
        
		
		
		
		
		
		
		
	}

	private void setVoterID(String[] voterID2)
	{
		//ArrayList<String> officeTitle = new ArrayList<String>();
		this.voterID = voterID2;
	}
	
    private String getVoterID(int a)
	{
		return voterID[a];
	}
	public void setVoterName(String[] voterName)
	{
		//ArrayList<String> officeTitle = new ArrayList<String>();
		this.voterName = voterName;
	}
	
	public String getVoterName(int a)
	{
		return voterName[a];
	}
	public void setVote(Boolean[] vote)
	{
		this.vote = vote;
	}
	
	public Boolean getVote(int a)
	{
		return vote[a];
	}
	
	
	
	private void buildPanel()
	{
		// TODO Auto-generated method stub
		voterIDMessage = new JLabel("Please Enter Your Voter ID.");
		button1 = new JButton("Cancel");
		button1.addActionListener(new ButtonListener());
		button2 = new JButton("OK");
		button2.addActionListener(new ButtonListener());
		idText = new JTextField(10);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel1.add(voterIDMessage);
		panel2.add(idText);
		panel3.add(button1);
		panel3.add(button2);
	}

	
	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//gets the  command
			String command = e.getActionCommand();
			String input = idText.getText();
			
			int index = Arrays.asList(voterID).indexOf(input);
			
			System.out.println(command);
			//check the command
			if(command.equals("Cancel"))
			{
				//close JUST this window
				System.out.println("You pressed " + command);
				setVisible(false);
				try
				{
					new Ballot("src/ballots.txt");
				} catch (FileNotFoundException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
			else if (command.equals("OK"))
			{
				System.out.println("You pressed " + command);
				//do a check to see if the voter was real
				//int whatever = voter.getVoterID(0);
				//Integer.parseInt()
				//setVoterID(0);|| getVote(3).equals("false")	getVote(3).booleanValue()==false	
				System.out.println( input);
				if(input.equals(getVoterID(index)) 	)
				{
					System.out.println( "Welcome " + getVoterName(index) +" at " + index);
					setVisible(false);
					dispose();
					
					//first, pass on VoterID to Ballot.java, then 
					//pass on BallotID & candidates first to ballot
					int tempInt = Integer.parseInt(voterID[index]);
					
					new Ballot(tempInt);
					
					
					
					
					
					if(getVote(index).booleanValue()==true)
					{
						System.out.println( "the index is " + index);
						System.out.println( "You have already voted");
						JOptionPane.showMessageDialog(null, "You have already voted. Leave!");
						
					}
				}
				else
				{
					System.out.println( "Enter again");
					JOptionPane.showMessageDialog(null, "Enter Again.");
				}
			}
			
			
			
		}
	}
}
