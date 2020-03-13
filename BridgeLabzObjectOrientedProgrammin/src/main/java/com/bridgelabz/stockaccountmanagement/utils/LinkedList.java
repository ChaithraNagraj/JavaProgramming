package com.bridgelabz.stockaccountmanagement.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

public class LinkedList<T> {
	final static Logger logger = Logger.getLogger(LinkedList.class);
	Node head;
	 class Node{
		T data; 
		 Node next;
		 Node(T d)
		 {
			 data=d;
			 next=null;
			 
		 }
	 }
	/**
	 * method to insert data into linked list at the beginning
	 * @param newData
	 */
	public void add(T newData)
	{
		// creating object of the node class and putting data
		Node newNode=new Node(newData);
		
		//making the new node as head
		newNode.next=head;
		
		//pointing head to the new node
		head=newNode;
	}
	/**
	 * method to insert the data into the linked list after particular position
	 * @param previousNode
	 * @param newData
	 */
	public void insert(Node previousNode,T newData)
	{
		if(previousNode==null)
		{
			logger.info("previous node cant  be null");
			return;
		}
		else 
		{
			//creating new node and putting data
			Node newNode=new Node(newData);
			//pointing the new node same as previous node
			newNode.next=previousNode.next;
			//connecting previous node to new node and breaking link between previous node and previous node next
			previousNode=newNode;
		}
	}
	/**
	 * method to insert data at the end of the linked list
	 * @param newData
	 */
	public void append(T newData)
	{
		//creating node and putting data
		Node newNode=new Node( newData);
		//if list is empty make new node as head
		if(head==null)
		{
			head=new Node(newData);
			return;
		}
		//this node is going to be the last node ,so making next of it as null
		 
		newNode.next=null;
		Node last=head;
		while(last.next!=null)
		{
			last=last.next;
			last.next=newNode;
			return;
		}
		
	}
	/**
	 * method to print the data present in the linked list
	 */
	public void printList()
	{
		Node printNode=head;
		while(printNode!=null)
		{
			logger.info(printNode.data);
			printNode=printNode.next;
		}
	}
	/**
	 * method to delete an element at particular position
	 * @param position
	 */
	public void removeAtPosition(int position)
	{
		//if the list is empty return
		if(head==null)
		{
			return;
		}
		//store head node
		Node temp=head;
		//if head needs to be removed
		if(position==0)
		{
			//change head
			head=temp.next;
			return;
		}
		//find the node of the previous element of the element to be removed
		for (int i = 0; temp!=null && i<position-1; i++) 
		{
			temp=temp.next;
			//if position is more than the number of nodes
			if(temp==null || temp.next==null)
			{
				return;
			}
			//Node temp.next is the node to be deleted
			Node next=temp.next.next;
			temp.next=next;
			
		}
		
	}
	/**
	 * method to remove element from list based on the key
	 * @param key
	 */
	public void remove(T key)
	{
		//store head node
		Node temp=head;
		Node previous=null;
		//if head node contains the key to be deleted
		if(temp!=null && temp.data==key)
		{
			//change head
			head=temp.next;
			return;
		}
		//search the key to be deleted and keep a track previous node as we need to change temp.next
		while(temp!=null&&temp.data!=key)
		{
			previous=temp;
			temp=temp.next;
		}
		//if key was not present in the list
		if(temp==null)
		{
			return;
		}
		//Unlink the node from linked list
		previous.next=temp.next;
	}
	/**
	 * method to search if the element is present in the list or not
	 * @param key
	 * @return boolean value which is true if the element is present ,false if element is not present
	 */
	public boolean search(T key)
	{
		Node currentNode=head;
		boolean status=false;
		while(currentNode!=null)
		{
			if(currentNode.data==key)
			{
				return true;
			}

				currentNode=currentNode.next;
		}
		return status;
	}
	/**
	 * method to check if the list is empty or not 
	 * @return boolean value which is true if the list is empty,false if the list is not empty
	 */
	public boolean isEmpty()
	{
		//if head is null it means the list is empty
		if(head==null)
		{
			return true;
		}
		
		return false;
	}
	/**
	 * method to find the size of the linked list
	 * @return integer value which is the number of elements  present in the linked list
	 */
	public int size()
	{
		Node currentNode =head;
	    int counter=0;
		while(currentNode!=null)
		{
			currentNode=currentNode.next;
			counter++;
		}
		return counter;
	}
	/**
	 * method to find the index of the element entered
	 * @param key
	 * @return integer value which is the position of the key entered
	 */
	public int index(T key)
	{
		Node currentNode=head;
		int index=0;
		if(currentNode==null)
		{
			return -1;
		}
		while( currentNode.data!=key)
		{
			currentNode=currentNode.next;	
			index++;
		}
		if(currentNode.next==null)
		{
			if(currentNode.data!=key)
			{
				return -1;
			}
		}
		return index;
	}
	/**
	 * method to remove and return the first element in the list
	 * @return integer value which is on the top of the list
	 */
	@SuppressWarnings("null")
	public T pop()
	{
		//storing the head
		Node currentNode=head;
		Node previous=null;
		//if the list is empty
		if(currentNode==null)
		{
		  logger.info("list is empty");
		}
		//traversing till the end of the list
		while(currentNode!=null)
		{
			previous=currentNode;
			currentNode=currentNode.next;
			
		}
	   previous.next=null;//unlinking the last node
	   return currentNode.data;
		
	}
	/**
	 * method to return and remove a particular node which matches the given key
	 * @param key
	 * @return integer value if the key matches the value present in the node
	 */
	public T pop(int position)
	{
		
		//store head
		Node currentNode=head;
		Node previous=null;
		//if list is empty
		if(position==0)
		{
			head=currentNode.next;
			return currentNode.data;
		}
		//if list is not empty and the key is present
		for(int i=0;currentNode.next!=null &&i<position;i++ )
		{
			previous=currentNode;//keep tracking the previous node
			currentNode=currentNode.next;
		}
		previous.next=currentNode.next;
		return currentNode.data;
	
	}
	/**
	 * method to print the data to the file
	 * @param fileName
	 * @throws IOException
	 */
	 public void printToFile(String fileName) throws IOException 
	    {
			
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file);
		
			Node temp = head;
			writer.write("[");
			//traversing till the last element
			while (temp != null) {
				if (temp.next != null)
					writer.write(temp.data + " ");
				else
					writer.write(temp.data+"");
				temp = temp.next;
			}
			writer.write("]");
		
			writer.flush();
			writer.close();
		}

	
	


}
