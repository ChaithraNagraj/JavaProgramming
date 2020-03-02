package com.bridgelabs.fs.datastructureprograms;

import org.apache.log4j.Logger;

public class DequeueUtility<T> {
	final static Logger logger=Logger.getLogger(DequeueUtility.class);
	public DequeueUtility(){	
	}
	
	Dequeue<T> front;
	Dequeue<T> rear;
	int size=0;
	
	//add front
	@SuppressWarnings("null")
	public void addFront(T c)
	{
		if(front==null) //if no element in list
		{
			front.data=c;
			rear=front;
		}
		else  //if element in list
		{
			Dequeue<T>tNode=null;
			tNode.data=c;
			tNode.next=front;
			front.pre=tNode;
			front=tNode;
		}
		size++;
	}
	
	//add rear
	public void addRear(T c)
	{
		if(front==null) //if no element in list
		{
			Dequeue<T>tNode=new Dequeue<T>(c);
			front=tNode;
			rear=front;
		}
		else  //if element in list
		{
			Dequeue<T>tNode=new Dequeue<>(c);
			rear.next=tNode;
			tNode.pre=rear;
			rear=tNode;
		}
		size++;
	}
	
	//remove front
	public T removeFront()
	{
		T val=null;
		if(front==null)
		{
			logger.info("No elements to delete");
		}
		else
		{
			val=front.data;
			front=front.next;
		}
		size--;
		return val;
	}
	
	//remove rear
	public T removeRear()
	{
		T val=null;
		if(front==null)
		{
			logger.info("No element to delete");
		}
		else
		{
			val=rear.data;
			rear=rear.pre;
			rear.next=null;
		}
		size--;
		return val;
	}
	
	//to remove
	public boolean isEmpty()
	{
		if(front==null)
			return true;
		else
			return false;
	}
 
	//return size of deque
	public int size()
	{
		return size;
	}
}
