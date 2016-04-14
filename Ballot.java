import java.io.*;
import java.util.*;

import javax.swing.*;

public class Ballot extends JFrame
{
	public static int numberOfBallots = getNumberOfBallots();
	private int ballotID;
	private String[][] candidate;
	private String[] officeTitle;
	 
	
	private String transferFile;
	private int temp;
	private String[][] tokens;
	private int [] BallotID;
	private String [] OfficeID;
	public static int ballotRows = getBallotRows();
	private String[][] registeredVoters;
	private int[] VoterID;
	private String[] VoterName;
	private String[] voted;
	private int[] voterID;
	private String[] voterName;
	private String[] vote;


	//CONSTRUCTOR
	public Ballot(String s) throws FileNotFoundException
	{
		transferFile = s;
	
	String filename = transferFile;
	
	String voters = "src/voters.txt";
	
	// gets "ballots.txt" from the command line
	//String filename = args[0];
	System.out.println("filename entered is: " + filename);
	System.out.println("filename entered is: " + voters);
	
	//opens the file and makes copies
	File file = new File(filename);
	File file2 = new File(voters);
	
	Scanner inputFile = new Scanner(file);
	Scanner inputFile2 = new Scanner(file2);

	//ArrayList to store ballots
	ArrayList<String[]> ballots = new ArrayList<String[]>();
	ArrayList<String[]> voterList = new ArrayList<String[]>();
	String[][] tokens = null;
	

	
	
	
	
	
	//while loop to fill the ArrayList
	while(inputFile.hasNextLine())
    {
    	String temp = inputFile.nextLine();
    
    
    	//splits temp up by ':' and ','
	 	String[] array = temp.split("[\\:\\,]+");
        ballots.add(array);
    
    
    }
    inputFile.close();
    
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
    
    
    tokens = new String[ballots.size()][ballots.get(0).length];
	        tokens = ballots.toArray(tokens);

	        //just a blank line
	        System.out.println();
	        
	        
	        //test printout of all of the cells
	        for (int row=0; row<tokens.length; row++)
	        {
	            for (int col=0; col<tokens[row].length; col++)
	            {
	                System.out.println("result: tokens[" + (row) + "][" + (col) + "]=" + tokens[row][col]);
	            }
	        }
	        
	        
	      //just a blank line
	        System.out.println();
	        
	        VoterID = new int[registeredVoters.length];
	        VoterName = new String[registeredVoters.length];
	        voted = new String[registeredVoters.length];
	        
	        //test printout of all of the cells
	        for (int row=0; row<registeredVoters.length; row++)
	        {
	        	int tempInt = Integer.parseInt(registeredVoters[row][0]);
            	VoterID[row] = tempInt;
            	System.out.println("VoterID[" + (row)+ "]" + VoterID[row]);
            	setVoterID(VoterID);
            	
            	VoterName[row] = registeredVoters[row][1];
            	System.out.println("VoterName[" + (row)+ "]" + VoterName[row]);
            	//setVoterName();
            	
            	voted[row] = registeredVoters[row][2];
            	System.out.println("voted[" + (row)+ "]" + voted[row]);
            	//setVote();
            	
	        }
	        
	        
	        
	        
	        setNumberOfBallots(tokens[0][0]);

	        
	        
	      
	        
	        
	        
	        
	        
	        
	        //just a blank line
	        System.out.println();
	        
    		//loop thru to setup BallotID
	        BallotID = new int[numberOfBallots];
    		for (int row=0; row<numberOfBallots; row++)
	        {
	        	int temp = Integer.parseInt(tokens[row+1][0]);
	            BallotID[row] = temp;
	            System.out.println("result: BallotID[" + (row)+ "]" + BallotID[row]);
	            //setBallotID(BallotID[row]);  
	        }
    		setBallotID(BallotID[1]);
    
    
    		//loop thru to setup OfficeID
    		OfficeID = new String[numberOfBallots];
    		for (int row=0; row<numberOfBallots; row++)
	        {
	        	String temp = tokens[row+1][1];
	            OfficeID[row] = temp;
	            System.out.println("result: OfficeID[" + (row)+ "]" + OfficeID[row]);
	            setOfficeTitle(OfficeID);  
	        }
    		//setOfficeID(OfficeID[1]);
    
    		
    		//find the longest row
    		int longestRow = 0;
    		for (int row = 0; row < tokens.length; row++)
    		{
    			if (tokens[row].length > longestRow)
    			{
    				longestRow = tokens[row].length;
    			}
    		}
    		System.out.println("result: longest row is : " + (longestRow - 2) );
    		setBallotRows( (longestRow - 2) );
    		
    		
    		for (int row=1; row<tokens.length; row++)
	        {
	            for (int col=2; col<tokens[row].length; col++)
	            {
	                System.out.println("result: candidates[" + (row) + "][" + (col) + "]=" + tokens[row][col]);
	                setCandidates(tokens);
	            }
	        }
	        
    		  MainWindow main = new MainWindow(getNumberOfBallots(),getBallotRows());
    		
    		
}
	
	
	
	
	public Ballot(int tempInt)
	{
		//first, pass on VoterID to Ballot.java, then 
		//pass on BallotID & candidates first to ballot
		int voterID = tempInt;
		new MainWindow(numberOfBallots,ballotRows,voterID, getballotID(),candidate );
	}
	private void setBallotRows(int longestRow)
	{
		ballotRows = longestRow;
	}
	public static int getBallotRows()
	{
		return ballotRows;
	}
	
	public void setNumberOfBallots(String s)
	{
		numberOfBallots = Integer.parseInt(s);
	}
	public static int getNumberOfBallots()
	{
		return numberOfBallots;
	}
	
	public void setBallotID(int a) 
	{
		ballotID = a;
	}
	public int getballotID()
	{
		return ballotID;
	}
	
	public void setCandidates(String[][] cand)
	{
		candidate = cand;
	}
	public String getCandidates(int row, int col)
	{
		return candidate[row][col];
	}
	
	public void setOfficeTitle(String[] officeID2)
	{
		//ArrayList<String> officeTitle = new ArrayList<String>();
		officeTitle = officeID2;
	}
	
	public String getOfficeTitle(int a)
	{
		return officeTitle[a];
	}
	
	
	
	
	
	
	public void setVoterID(int[] voterID2)
	{
		//ArrayList<String> officeTitle = new ArrayList<String>();
		this.voterID = voterID2;
	}
	
	public int getVoterID(int a)
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
	public void setVote(String[] vote)
	{
		this.vote = vote;
	}
	
	public String getVote(int a)
	{
		return officeTitle[a];
	}
}
