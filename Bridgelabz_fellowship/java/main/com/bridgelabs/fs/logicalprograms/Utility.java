package com.bridgelabs.fs.logicalprograms;

import org.apache.log4j.Logger;

import com.bridgelabs.fs.customiseexception.Timeinvalidexception;
import com.bridglabz.utility.InputUtility;

public class Utility {
	static Logger logger = Logger.getLogger(Utility.class);

	//@gambler
public static int Gamblerwin(int stake, int goal,int trials) {
	int bets=0;
	int wins=0;
    for (int t = 0; t < trials; t++) {
        int cash = stake;
        while (cash > 0 && cash < goal) {
            bets++;
            if (Math.random() < 0.5)
            	cash++;     // win $1
            else              
            	cash--;     // lose $1
        }
        if (cash == goal) 
        	wins++;       // did gambler go achieve desired goal?
    }
  logger.info(wins+ " wins of" +trials);
  logger.info("percentage of won="+ 100*wins/trials);
  logger.info("average bets="+1.0 *bets/trials);
	return wins;
    }
//@coupon java

       // return a random coupon between 0 and n-1
    public static int getCoupon(int n) {
        return (int) (Math.random() * n);
    }

        // return number of cards you collect before obtaining one of each of the n types
    public static int collect(int n) {
        boolean[] isCollected = new boolean[n];  // isCollected[i] = true if card type i already collected
        int count = 0;                           // number of cards collected
        int distinct  = 0;                       // number of distinct card types collected

        // repeat until you've collected all n card types
        while (distinct < n) {
            int value = getCoupon(n);            // pick a random card 
            count++;                             // if condition matches it increases one more card
            if (!isCollected[value]) {           // discovered a new card type
                distinct++;
                isCollected[value] = true;
            }
        }
        return count;
    }
    
    //@stopwatch
    public static long getElapsedTime(long end)throws Timeinvalidexception {
   if(end<=0) {
		throw new Timeinvalidexception("not valid");

   }
    	final long start = System.currentTimeMillis();
    	logger.info("start time "+ start);
    	logger.info("enter the 2 to stop the timer");
    	//int u1=InputUtility.intVal();

    	end = System.currentTimeMillis();
    	logger.info("end time is "+ end );

    	logger.info("Took: " + ((end - start) / 1000000.0) + "ms");
    	logger.info("Took: " + (end - start)/ 1000000000.0 + " seconds");
		return end;
	}
    
    //@ method for tic-toc
    //private static int counter;
    private static  char posn[]=new char[10];
    private static  char player;
    public static  void newBoard()
    {
        
        char posndef[] = {'0','1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int i;
        //counter = 0;
        player = 'X';
        for (i=1; i<10; i++) posn[i]=posndef[i];
        currentBoard();
        
        
    }
    public static  String currentBoard()
    {
       
    	logger.info(  " " + posn [1] + "   | " +posn [2]+ "  | " +posn [3]);
    	logger.info(  "     |    |   " );
    	logger.info(  "  ___|____|___ " );
    	logger.info(  " " +posn [4]+ "   | " +posn [5]+ "  | " +posn [6]);
    	logger.info(  "     |    |   " );
    	logger.info(  "  ___|____|___ " );
    	logger.info(  " " +posn [7]+ "   | " +posn [8]+ "  | " +posn [9]);
    	logger.info(  "     |    |   " );
    	logger.info(  "     |    |   " );
        return "currentBoard";
    }
    
    public static void play()
    {
        //int spot;
        char blank = ' ';
        
        logger.info(  "Player " + getPlayer() +" will go first and be the letter 'X'" );
        
        do {
            currentBoard();              // display current board
            
            logger.info(  "\n\n Player " + getPlayer() +" choose a posn." );
            
            boolean posTaken = true;
            while (posTaken) {
                // System.out.println( "position is taken, please enter a valid space");
                //Scanner in =new Scanner (System.in);
                int spot1=InputUtility.intVal();
                posTaken = checkPosn(spot1);
                if(posTaken==false)
                posn[spot1]=getPlayer();
            }
            
            logger.info(  "Nice move." );
            
            currentBoard();              // display current board
            
            nextPlayer();
        }while ( checkWinner() == blank );
        
    }
    
    public static  char checkWinner()
    {
        char Winner = ' ';
        
        // Check if X wins
        if (posn[1] == 'X' && posn[2] == 'X' && posn[3] == 'X') Winner = 'X';
        if (posn[4] == 'X' && posn[5] == 'X' && posn[6] == 'X') Winner = 'X';
        if (posn[7] == 'X' && posn[8] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[1] == 'X' && posn[4] == 'X' && posn[7] == 'X') Winner = 'X';
        if (posn[2] == 'X' && posn[5] == 'X' && posn[8] == 'X') Winner = 'X';
        if (posn[3] == 'X' && posn[6] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[1] == 'X' && posn[5] == 'X' && posn[9] == 'X') Winner = 'X';
        if (posn[3] == 'X' && posn[5] == 'X' && posn[7] == 'X') Winner = 'X';
        if (Winner == 'X' )
        {logger.info("Player1 wins the game." );
            return Winner;
        }
        
        // Check if O wins
        if (posn[1] == 'O' && posn[2] == 'O' && posn[3] == 'O') Winner = 'O';
        if (posn[4] == 'O' && posn[5] == 'O' && posn[6] == 'O') Winner = 'O';
        if (posn[7] == 'O' && posn[8] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[1] == 'O' && posn[4] == 'O' && posn[7] == 'O') Winner = 'O';
        if (posn[2] == 'O' && posn[5] == 'O' && posn[8] == 'O') Winner = 'O';
        if (posn[3] == 'O' && posn[6] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[1] == 'O' && posn[5] == 'O' && posn[9] == 'O') Winner = 'O';
        if (posn[3] == 'O' && posn[5] == 'O' && posn[7] == 'O') Winner = 'O';
        if (Winner == 'O' )
        {
        	logger.info( "Player2 wins the game." );
        return Winner; }
        
        // check for Tie
        for(int i=1;i<10;i++)
        {
            if(posn[i]=='X' || posn[i]=='O')
            {
                if(i==9)
                {
                    char Draw='D';
                    logger.info(" Game is stalemate ");
                    return Draw;
                }
                continue;
            }
            else
            break;
            
        }
        
        return Winner;
    }
    
    public static boolean checkPosn(int spot)
    {
        
        
        if (posn[spot] == 'X' || posn[spot] == 'O')
        {
        	logger.info("That posn is already taken, please choose another");
            return true;
        }
        else {
            return false;
        }
        
        //  counter++;
        //    return false;
    }
    
    
    
    public static  void nextPlayer()
    {
        if (player == 'X')
        player = 'O';
        else player = 'X';
        
    }
    
    public String getTitle()
    {
        return "Tic Tac Toe" ;
    }
    
    public static  char getPlayer()
    {
        return player;
    }
    
}

        