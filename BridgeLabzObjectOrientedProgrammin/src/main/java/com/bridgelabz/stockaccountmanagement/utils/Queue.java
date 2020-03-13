package com.bridgelabz.stockaccountmanagement.utils;

import org.apache.log4j.Logger;

public class Queue<T> {
	final static Logger logger = Logger.getLogger(Queue.class);
	public class QNode
	{
		T key;
		QNode next;
		//constructor to create a new linked list node
		public QNode(T key)
		{
			this.key=key;
			this.next=null;
		}
		
	}
	//A class to represent a queue
	//the queue front stores the front node of LL and rear stores the
	//last node of LL
	 QNode front;
	 QNode rear;
	 public Queue()
	 {
		 this.front=null;
		 this.rear=null;
	 }
	 //method to add an key to the queue
	 public void enqueue(T key)
	 {
		 // Create a new Linked list node
		 QNode temp=new QNode(key);
		 //if queue is empty , then new node is front and rear both
		 if(rear==null)
		 {
			 front=temp;
			 rear=temp;
			 return;
		 }
		 //add the new node at the end of queue and change rear
		  rear.next=temp;
		   rear=temp;
	 }
	 //method to remove an key from queue
	 
	public T dequeue()
	 {
		 //if queue is empty, return NULL
		 if(front==null)
		 {
			 return null ;
		 }
		 //store previous front and move front one node ahead
		 QNode temp=front;
		 front=front.next;
		 //if front because NULL, then change rear also as NULL
		 if(front==null)
		 {
			 rear=null;
		 }
		 return temp.key;
	 }
	 /**
	  * method to check if the queue is empty or not 
	  * @return boolean value which is true if queue is empty, false if queue is not empty
	  */
	 public boolean isEmpty()
	 {
		 if(front==null && rear==null)
		 {
			 return true;
			 
		 }
		 return false;
		 
	 }
	 /**
	  * method to find the size of the queue
	  * @return integer value which is number of elements present in the queue
	  */
	 public int size()
	 {
		 int counter=0;
		 //if queue is empty
		 if(front ==null && rear==null)
		 {
			 return 0;
		 }
		 //if queue is not empty
		 while(front!=null && rear!=null)
		 {
			 front=front.next;
			 counter++;
			 
		 }
		return counter;
	 }
	 /**
	  * method to print the data present in queue
	  */
	 public void print()
	 {
		QNode current=front;
		while(current!=null)
		{
			logger.info(current.key);
			current=current.next;
		}
		 
		 
	 }
	 public T getFront()
	 {
		return front.key;
		 
	 }
	

}
