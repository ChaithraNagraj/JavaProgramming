package com.bridgelabs.fs.datastructureprograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Stack;
import org.apache.log4j.Logger;
public class Utility {
//for unordered
	final static Logger logger=Logger.getLogger(Utility.class);
	static String[] stringArray;
    //static int[] intArray;

	//Reading string from file
	@SuppressWarnings("resource")
	public static Node readFile(Node start)
	{
		try{
	           	FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\data.txt");
	           	char ch;
	           	String word3="";
	           	while (fis.available() > 0)
	           	{
					ch = (char) fis.read();
	             	word3=word3+ch;
	           	}
	           	String[] wordsArray=word3.split(" ");
				for(int i =0; i < wordsArray.length ; i++)
				{
	           		start=addWordstoList(start,wordsArray[i]);
				}
			}
	     	catch(NullPointerException ne)
	     	{
	         logger.info(ne);
	     	}
			catch(IOException e){
			}
			return start;
	 }//End of read method

	//Insert words...........
	public static Node addWordstoList(Node node1,String str)
	{
	   Node node2=node1;
	   Node newNode=new Node();
	   newNode.data1=str;
	   newNode.nextNode=null;
	   if(node1==null)
	   {
	     return newNode;
	   }
	   else{
	     while(node1.nextNode!=null)
	     {
	       node1=node1.nextNode;
	     }
	     node1.nextNode=newNode;
	   }
	   return node2;
	}//End of insert method

	//Search words
	public static Node searchData(Node node,String word)
	{
	     Node temp=node;
	     while(node.nextNode!=null){
	       if(word.compareTo((node.nextNode).data1)==0)
	       {
	         node.nextNode=(node.nextNode).nextNode;
	         logger.info("Word is Found");
	         logger.info("the founded word is deleted from the file");
	         logger.info("file saved");
	         return temp;
	       }
	       node=node.nextNode;
	     }
	     logger.info("Word is not Found");
	     logger.info("the not founded word is added to the file");
	     logger.info("file saved");
	     temp=addWordstoList(temp,word);
	     return temp;
	}//End of Search word

	//writeToFile
	public static void writeDataToFile(String nWord)
	{
		try{
			File fi=new File("C:\\Users\\admin\\Desktop\\data.txt");
	      	fi.createNewFile();
	      	FileWriter fw=new FileWriter(fi);
	        fw.write(nWord);
	        fw.close();
		}
		catch(IOException e){
		}
	}
	
	
//@method for orderedlinkedlis
    static int[] intArray;

	//Reading string from file
	public Node readFile1(Node start)
	{
		try
		{
			@SuppressWarnings("resource")
			FileInputStream fis = new FileInputStream("C:\\Users\\admin\\Desktop\\integer tex.txt");
			char ch;
			String word3="";

			while (fis.available() > 0)
			{
				ch = (char) fis.read();
				word3=word3+ch;
			}
			String[] wordsArray=word3.split(" ");
			int[] inputArray=new int[wordsArray.length-1];

			for(int i=0;i<wordsArray.length-1;i++)
			{
				inputArray[i]=Integer.parseInt(wordsArray[i]); 
			}
			inputArray=sort(inputArray);

			for(int i =0; i < wordsArray.length-1 ; i++)
			{
				start=addWordstoList(start,inputArray[i]);
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		return start;
	}

	//read integer file
	public static int[] integerFileReader()
	{
		try
		{
			String intFile = new String();
			FileReader fr = new FileReader("C:\\Users\\admin\\Desktop\\integer tex.txt");
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
		    String s;

		    while((s = br.readLine()) != null) 
			{
		        intFile += s;
		    }

		    intFile = intFile.replaceAll("\\n",",");
		    intFile = intFile.trim();
		    stringArray = intFile.split(","); 
		    intArray = new int[stringArray.length];

		    for(int i=0; i <intArray.length;i++)
		    {
		        try
		        {
		            intArray[i]= Integer.parseInt(stringArray[i]);
		        }
		        catch(NumberFormatException e)
		        {
		            logger.info(e);
		        }
		    }
		}
		catch(Exception obj)
		{
		    logger.info("e");
		}
        	return intArray;
    }

	//End of insert method
	public Node addWordstoList(Node node1,int num)
	{
    	Node node2=node1;
    	Node newNode=new Node();
    	newNode.data=num;
    	newNode.nextNode=null;

	    if(node1==null)
	    {
	      	return newNode;
	    }
	    else
		{
	      	while(node1.nextNode!=null)
	      	{
				node1=node1.nextNode;
	      	}
	      		node1.nextNode=newNode;
	    }
    	return node2;
	}//End of insert method

	//Sorting linked list in ascending order
  	public static int[] sort(int[] arr )
	{
    	int size=arr.length;
    	for(int i=size;i>0;i--)
		{
      		for(int j=1;j<size;j++)
			{
        		if(arr[j-1]>arr[j])
				{
          			int temp=arr[j-1];
          			arr[j-1]=arr[j];
          			arr[j]=temp;
        		}
      		}
      		size--;
    	}
    	return arr;
  	}//End of sorting method

	////Searching number
  	public Node search(Node tNode1, int num)
	{
    	Node tNode=tNode1;

    	//No elements in an list(List empty)
    	if(tNode==null)
		{
      		Node newNode=new Node();
			newNode.data=num;
			tNode=newNode;
			return tNode; 
    	}

    	//Search number is first in list
    	if(tNode.data==num)
		{
      		tNode=null;
      		return tNode1; //
    	}

    	//Search num
    	while(tNode!=null)
		{
      		if(tNode.nextNode==null)
			{
        		return tNode1;
      		}
      
      		if(tNode.nextNode.data==num)
			{
        		tNode.nextNode=tNode.nextNode.nextNode;
        		return tNode1;
      		}
     	 	tNode=tNode.nextNode;
    	}
    	return tNode1;
  	}

	//method to write in file
  	public void writeFile(Node tNode)
	{
    	try
		{
			String tString="";
		    File file=new File("C:\\Users\\admin\\Desktop\\integer tex.txt");
		    file.createNewFile();
		    FileWriter fw=new FileWriter(file);

		    while(tNode!=null)
			{
		      	tString+=String.valueOf(tNode.data);
		      	tString+=" ";
		      	tNode=tNode.nextNode;
		    }
		    //System.out.println("string "+tString );
		    fw.write(tString);
		    fw.close();
		}
		catch(IOException e)
		{
           logger.info(e);
		}
	} //end of method
  	
  	 
//@3 method for balancedparantheses
  	 //! stack logic
  	
  	private static int maxSize;
	private static long[] stackArray;
	private  static int top;

	//for size  
	public static void StackLogic(int s)
	{
	maxSize = s;
	stackArray = new long[maxSize];
	top = -1;
	}
	//for push   
	public void push(long j)
	{
	stackArray[++top] = j;
	}
	//for pop   
	public long pop() 
	{
	return stackArray[top--];
	}
	//for peek   
	public long peek() 
	{
	return stackArray[top];
	}
	//to check whether stack is empty	   
	public static boolean isEmpty()
	{
	return (top == -1);
	}
	//to check whether stack is full	   
	public boolean isFull()
	{
	return (top == maxSize - 1);
	}
	
	//!balenced parantheses logic implement using stack
	
	public static boolean check(String s) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			/*
			 * push open parenthesis “(“ and pop closed parenthesis “)”. At the End of the
			 * Expression if the Stack is Empty then the Arithmetic Expression is Balanced.
			 */
			char c = s.charAt(i);
			if (c == '(')
				st.push(s.charAt(i));
			else if (c == ')')
				st.pop();
		}
		return st.isEmpty();
	}
	
	
//@4 cash counter
/*  Class linkedQueue  */
//public class CashCounterLogic
//{
	 static Node1 front;
	 static Node1 rear;
    static int size;
 
    /* Constructor */
    public static  void CashCounterLogic()
    {
        front = null;
        rear = null;
        size = 0;
    }    
    
    /*  Function to check if queue is empty */
    public static boolean isEmpty1()
    {
        return front == null;
    }   
    
    /*  Function to get the size of the queue */
    public static int getSize()
    {
        return size;
    }    
    
    /*  Function to insert an element to the queue */
    public static  void insert(int data)
    {
        Node1 node = new Node1();
        if (rear == null)
        {
            front = node;	
            rear = node;
        }
        else
        {
            front=Node1.setLink(node);
            rear = Node1.getLink();
        }
        size++ ;
    }   
    
    /*  Function to remove front element from the queue */
   	public static int remove()
    {
        if (isEmpty())
		{
        	throw new NoSuchElementException("Underflow Exception");
		}
        @SuppressWarnings("unused")
		Node1 ptr = front;
        front = Node1.getLink();        
        if (front == null)
		{
            rear =null;
			size-- ; 
		}       
        return Node1.getData();
    }    
    
    /*  Function to check the front element of the queue */
    public static  int peek1()
    {
        if (isEmpty1())
		{
            throw new NoSuchElementException("Underflow Exception");
		}
        return Node1.getData();
    }    
    
    /*  Function to display the status of the queue */
    public static void display()
    {  
		int ptr1=0;
        logger.info("Available Balance = ");
        if (size == 0)
        {
            logger.info("Empty");
            return ;
        }
        Node1 ptr = front;
        while (ptr != Node1.getLink() )
        { 
        	ptr1=ptr1+Node1.getData();
        	logger.info(ptr1);
            ptr = Node1.getLink();
        }
        logger.info(" ");        
    }
    
    
    
  //@5 hashing function  
    /**Create a Slot of 10 to store Chain of Numbers that belong to each Slot to efficiently search a number from a given set of number
    **/
	  	static OrderedList[] order=new OrderedList[11];

	  	public static void HashingFunction()
	  	{
			int[] retArray = Utility.integerFileReader();

			for(int i=0; i<retArray.length; i++)
			{
				int rem = retArray[i]%11;
				if(order[rem]== null)
				{
					order[rem] = new OrderedList();
					order[rem].addItem(retArray[i]);
				}
				else
				{
					order[rem].addItem(retArray[i]);
	            }
			}
			for(int i=0;i<11;i++)
			{
			logger.info(i);
				if(order[i] !=null)
				{
					order[i].display();
				}
			}
		}

//@7 method for prime number
	  		//public static void ExArrayPrimeNumberMatrix()
	  		//{
	  			// Function to check a number is prime or not
	  			public static boolean isPrime(int n) 
	  			{
	  				//int n=1000;
	  				int c = 0;
	  				for(int i = 1; i<=1000; i++)
	  				{
	  					if(n%i == 0)
	  						c++;
	  				}
	  				if(c == 2)
	  					return true;
	  				else
	  					return false;
	  			}
	  			
//@8 method for calender 2darray
	  			
	  			static int[][] calender = new int[5][7];
	  			static int[] month = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	  			static void initCal() {
	  				for (int i = 0; i < calender.length; i++) {
	  					for (int j = 0; j < calender[i].length; j++) {
	  						calender[i][j] = -10;
	  					}
	  				}
	  			}

	  			public static void display(int m) {
	  				logger.info("	Sun	Mon	Tue	Wed	Thu	Fri	Sat");

	  				for (int i = 0; i < calender.length; i++) {
	  					for (int j = 0; j < calender[i].length; j++) {
	  						if (calender[i][j] < 0 || calender[i][j] > month[m - 1]) 
	  						{
	  						logger.info("\t ");
	  						} else if (calender[i][j] > 0) {
	  							logger.info("\t" + calender[i][j] + " ");
	  						}
	  					}
	  				logger.info("\t");
	  				}
	  			}

	  			 public static void putCalender(int d) {
	  				int d1 = 1;
	  				for (int i = d; i < calender[0].length; i++) {
	  					// System.out.print(d1);
	  					calender[0][i] = d1++;
	  				}
	  				for (int i = 1; i < calender.length; i++) {
	  					for (int j = 0; j < calender[i].length; j++) {
	  						calender[i][j] = d1++;
	  					}
	  				}

	  			}

	  			 public static void dispCalender(int m, int y) {
	  				int d = dayOfWeek(m, y);
	  				initCal();
	  				putCalender(d);
	  				display(m);

	  			}

	  			 public static int dayOfWeek(int m, int y) {
	  				int d = 1;
	  				int y0 = y - (14 - m) / 12;
	  				int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
	  				int m0 = m + 12 * ((14 - m) / 12) - 2;
	  				int d0 = (d + x + (31 * m0) / 12) % 7;
	  				return d0;
	  			}
	  			
	
	  			 
//@9palindrome checker using Dequeue and dequeutility both class created for
	  			 //the purpose of palindrome checker
	  	
       public static  void ispalindrome(String s) 
               {
    	   DequeueUtility<Character> utility=new DequeueUtility<Character>();

	  				//adding each character to the rear of the deque
	  				for(int i=0;i<s.length();i++)
	  				{
	  					char c =s.charAt(i);
	  					utility.addRear(c);
	  				}
	  				int flag=0;

	  				while(utility.size()>1)
	  				{
	  					if(utility.removeFront()!=utility.removeRear())
	  					{
	  						flag=1;
	  						break;
	  					}
	  				}

	  				if(flag==0)
	  				{
	  					logger.info("String is palindrome");
	  				}
	  				else
	  				{
	  					logger.info("String is not palindrome");
	  				}
	  			}  		
      
 //13 mehod for calendarqueue
       public static void printQueueCalendar(int month, int year) {
    	   Queue<String> queue=new Queue<String>();
    	   String[] months= {" ","jan", "feb","march","april","may","june","july",
    			   "august","sep","nove", "dec"};
    	   for(int i=0;i<months.length;i++) {
    		   queue.enque(months[i]);//add months to queue
    	   }
    	   int[] days= {0,31,28,31,30,31,30,31,31,30,31,30,31 };
    	   for(int i=0;i<days.length;i++){
    		 queue.enque(Integer.toString(days[i]));  
    	   }
    	  //if(month==2 && )
}
}