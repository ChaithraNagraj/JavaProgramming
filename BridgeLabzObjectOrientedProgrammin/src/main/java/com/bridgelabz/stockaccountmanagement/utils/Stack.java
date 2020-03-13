package com.bridgelabz.stockaccountmanagement.utils;

import org.apache.log4j.Logger;

public class Stack<T> {
	final static Logger logger = Logger.getLogger(Stack.class);
	// creating a head node 
				Node root;
				static int top;  //variable to keep track of the top 
				//declaring a type Node
				class Node
				{
					T data;       //a variable to store data in the node
					Node next;    //a variable to store the address of the next node
					Node(T item){
						data = item; 
					}
				}
				/**
				 * constructor to create a empty stack 
				 */
				public Stack() 
				{
					root = null;
					top = -1;
				}
				/**
				 * an instance method to add the elements into the stack at the last position
				 * @param item
				 */
				public void push(T item) {
					//creating a new node of given data
					Node newNode = new Node(item);
					//if stack is empty making the new node as the root node
					if(root==null) {
						root = newNode;
						top++;
					}
					//otherwise adding the new node at the last(i.e on top) and  making it as root node
					else {
						Node temp = root;      //temporary node to keep track of root node
						root = newNode;       //making new node as root node
						newNode.next = temp;  //linking the previoous node with the new node
						top++;
					}
				}
				
				/**
				 * an instance method to delete the last element and returning it 
				 * @return  last element it the stack
				 */
				public T pop() {
					
					T popped = null ;
					//checking stack is empty or not
					if(root==null) {
						System.out.println("Stack is empty ");
					}
					//if it is not empty removing the last element
					else {
						popped = root.data;
						root = root.next;   //deleting the root node
						top--;
					}
					return popped;
				}
				
				/**
				 * an instance method to know the last element in the stack
				 * @return last element in the stack
				 */
				public T peek() {
					//checking if stack is empty
					if(root==null) {
						logger.info("Stack is Empty");
						return null;
					}
					return root.data;  //returning the data present in the root node
				}
				/**
				 * an instance method to test whether stack is empty?
				 * @return true if stack is empty,else false
				 */
				public boolean isEmpty() {
					if(root==null) {
						return true;
					}
					return false;
				}
				
				/**
				 * an instance method to know the no of elements present in the stack
				 * @return size of the stack
				 */
				public int size() {
					return top+1;
				}
				public void print()
				{
					Node temp=root;
					while(temp!=null)
					{
						logger.info(temp.data+" ");
						temp=temp.next;
					}
				}


}
