package com.bridgelabs.fs.datastructureprograms;

public class Node {
	// for orderd ,unorderd,balancedparathese
	public String data1;
	public int data;
	public Node nextNode;

	// constructor
	public Node() {
	}

	public Node(int data) {
		this.data = data;
		this.nextNode = null;
	}

	public Node(String data) {
		this.data1 = data;
	}
}
