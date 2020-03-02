package com.bridgelabs.fs.datastructureprograms;

public class Node1 {
//for queue,bankcash counter;

	protected static int data;
    protected static Node1 link;


	/*  Constructor  */
    public static  void Node()
    {
        link = null;
        data = 0;
    }  
    
    /* Parameterized Constructor  */
    /*public static  void Node1(int d,Node1 n)
    {
        data = d;
        link = n;
    } */ 
    
    /*  Function to set data to current Node  */
   	public static  void setData(int d)
    {
        data = d;
    }   
    
   	/*  Function to get link to next node  */
   	public static Node1 getLink()
    {
     	return link;
    }  
    
	/*  Function to set link to next Node  */
    public static Node1 setLink(Node1 node)
    {
        return link = node;
    }  

    /*  Function to get data from current Node  */
    public static int getData()
    {
        return data;
    }
}