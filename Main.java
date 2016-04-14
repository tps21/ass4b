import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{

	private static int numberOfBallots;
	private static String ballotID, s;
	private static String[][] cand;
	private static String[][] tokens;
	private static Ballot ballot;
	



	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		
		
		//load ballots use args[0] for submission but 'ballots.txt'
		Ballot test = new Ballot("src/ballots.txt");
		
		
		
		//String[][] numberOfBallots = 
		
		//loadBallots();
		//int ballots = 0;
		//System.out.println();
		//System.out.println("numberOfBallots is " + numberOfBallots[0][0]);
		//System.out.println(ballots);
		
		//ballot = new Ballot();
		//int temp = numberOfBallots(numberOfBallots);;
		
		//ballot.setNumberOfBallots(temp);
		System.out.println("# of ballots "+test.getNumberOfBallots());
		
		//ballot.setCandidates(tokens[2][3]);
		//System.out.println("title is "+ballot.getOfficeTitle());
		
		
		
		//Main window
		
		
		
		
		
		
		
		
		//new VoterIDWindow();
		
		//new ConfirmationWindow();
		
		//Denial window is optional
		//new DenialWindow();
		
		//new ConfirmVoteWindow();
		
		//new ThankYouWindow();
		//test.setOfficeTitle(s);
		String s = "five";
		System.out.println("title is " + test.getOfficeTitle(0));
		System.out.println("the candidate is "+test.getCandidates(2,2));
		
		
		String title = test.getOfficeTitle(1);
		//new MainWindow(title);
		
	}
	/**
	public static void loadBallots() throws FileNotFoundException, IOException, NullPointerException
	{
		// gets "textFile.txt" from the command line
				//use for terminal
				//String filename = args[0];
		        
				//use for eclipse
				File file = new File("src/ballots.txt");
		        FileReader fReader = new FileReader(file);
		        BufferedReader bReader = new BufferedReader(fReader);
		        String temp = null;

		        //ArrayList to store ballots
		        ArrayList<String[]> ballots = new ArrayList<String[]>();
		        String[][] tokens = null;

		      //while loop to fill the array and then the ArrayList
		        while((temp = bReader.readLine()) != null)
		        {
		        	//splits temp up by ':' and ','
		            String[] array = temp.split("[\\:\\,]+");
		            ballots.add(array);
		        }
		        
		        //closes bReader
		        bReader.close();

		        tokens = new String[ballots.size()][ballots.get(0).length];
		        tokens = ballots.toArray(tokens);

		        //just a blank line
		        System.out.println();

		        //test printout of all of the cells
		        for (int row=0; row<tokens.length; row++)
		        {
		            for (int col=0; col<tokens[row].length; col++)
		            {
		                System.out.println("result[" + (row) + "][" + (col) + "]=" + tokens[row][col]);
		            }
		        }
		        //just a blank line
		        System.out.println();
		        
				numberOfBallots = Integer.parseInt(tokens[0][0]);
				
				
				ArrayList<String> ballotID = new ArrayList<String>();
				for (int row=0; row<numberOfBallots; row++)
				{
					ballotID.add(tokens[row+1][0]);
					System.out.println(ballotID.get(row));
				}
				
				ArrayList<String> officeID = new ArrayList<String>();
				for (int row=0; row<numberOfBallots; row++)
				{
					officeID.add(tokens[row+1][1]);
					System.out.println(officeID.get(row));
					String s = officeID.get(row);
					System.out.println(s);
					//ballot.setOfficeTitle(s);
				}
		//return tokens;
	}
*/
	

	private static int numberOfBallots(int numberOfBallots)
	{
		int ballots = numberOfBallots;
		return ballots;
	}
}
