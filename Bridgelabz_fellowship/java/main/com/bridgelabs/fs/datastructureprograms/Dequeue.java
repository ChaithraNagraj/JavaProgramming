package com.bridgelabs.fs.datastructureprograms;

public class Dequeue<T> {
	public T data;
	public Dequeue<T>next;
	public Dequeue<T>pre;
	
	public  Dequeue()
	{
		this.next=null;
		this.pre=null;
	}
	
	public Dequeue(T val)
	{
		this.data=val;
		this.next=null;
		this.pre=null;
	}
}
