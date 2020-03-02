package com.bridgelabs.fs.datastructureprograms;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.bridglabz.utility.InputUtility;
import com.bridgelabs.fs.datastructureprograms.Utility;

public class OrderedList {
	final static Logger logger = Logger.getLogger(OrderedList.class);
	Node head;

	// get data From a file
	void getDataFromFile() {
		int[] retArry = Utility.integerFileReader();
		int size = retArry.length;
		logger.info("Array Size is " + size);
		for (int i = 0; i < size; i++) {
			addItem(retArry[i]);
		}
	}

	// Function for List
	public void List() {
		if (head == null) {
			logger.info("List is Empty ");
		}
	}

	// add item Function
	public void addItem(int data) {
		Node newNode = new Node(data);
		newNode.nextNode = null;
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.nextNode != null) {
				temp = temp.nextNode;
			}
			temp.nextNode = newNode;
		}
	}

	// Display Function
	public void display() {
		Node temp = head;
		while (temp != null) {
			logger.info(temp.data + "---->");
			temp = temp.nextNode;
		}
		logger.info(" ");
	}

	// Size of Function
	public int size() {
		count = 0;
		Node temp = head;
		while (temp.nextNode != null) {
			temp = temp.nextNode;
			count++;
		}
		logger.info("sizze of Linked List" + count);
		return count;
	}

	static int count = 0;

	// Serching of a Word Function
	public void searchData(int s) {
		Node temp = head;
		boolean flag = false;
		while (temp.nextNode != null) {
			count++;
			if (temp.data == s) {
				logger.info(" number is found At " + count);
				flag = true;
				break;
			}
			temp = temp.nextNode;
		}

		if (flag) {
			removeData(count);
		} else {
			addItem(s);
			logger.info("After Adding a LIst ");
			display();
		}
	}

	// removeWord From a Linked lIst
	public void removeData(int count) {
		if (count == 1) {
			head = head.nextNode;
			logger.info("After Deleting LIst is ");
			display();
		} else {
			Node temp = head;
			Node prev = null;
			while (count > 1) {
				prev = temp;
				temp = temp.nextNode;
				count--;
				//System.out.println("==>" + prev.nextNode);
			}
			prev.nextNode = temp.nextNode;
			//System.out.println("==>" + prev.nextNode);
			logger.info("After Deleting LIst is ");
		}
	}

	public static void main(String[] args) {
		PropertyConfigurator.configure("src//log4j.properties");
		OrderedList obj = new OrderedList();
		obj.getDataFromFile();
		obj.display();
		logger.info("Enter a number to Search");
		int s = InputUtility.intVal();
		obj.searchData(s);
		obj.display();
	}
}
