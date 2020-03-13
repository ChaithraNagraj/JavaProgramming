package com.bridgelabz.deckofcards.services;

public class Queue<T> {
	private int capacity;
	T queueArr[];
	int front = 0;
	int rear = -1;
	int currentSize = 0;
	
	@SuppressWarnings("unchecked")
	public Queue(int queueSize){
		this.capacity = queueSize;
		queueArr = (T[]) new Object[this.capacity];
	}

	/**
	 * this method adds element at the end of the queue.
	 * @param item
	 */
	public void insert(T item) {
		if (isQueueFull()) {
			System.out.println("Overflow ! Unable to add element: "+item);
		} else {
			rear++;
			if(rear == capacity-1){
				rear = 0;
			}
			queueArr[rear] = item;
			currentSize++;
//			System.out.println("Element " + item+ " is pushed to Queue !");
		}
	}
   public int getSize()
   {
	   return currentSize;
   }
	/**
	 * this method removes an element from the top of the queue
	 */
	public void remove() {
		if (isQueueEmpty()) {
			System.out.println("Underflow ! Unable to remove element from Queue");
		} else {
			front++;
			if(front == capacity-1){
				System.out.print(queueArr[front-1]+" ");
				front = 0;
			} else {
				System.out.print(queueArr[front-1]+" ");
			}
			currentSize--;
		}
	}
	
	/**
	 * This method checks whether the queue is full or not
	 * @return boolean
	 */
	public boolean isQueueFull(){
		boolean status = false;
		if (currentSize == capacity){
			status = true;
		}
		return status;
	}
	
	/**
	 * This method checks whether the queue is empty or not
	 * @return
	 */
	public boolean isQueueEmpty(){
		boolean status = false;
		if (currentSize == 0){
			status = true;
		}
		return status;
}
}
