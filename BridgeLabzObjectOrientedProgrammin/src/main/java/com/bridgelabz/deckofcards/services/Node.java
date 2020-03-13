package com.bridgelabz.deckofcards.services;

public class Node<T> {
	private T value;
    private Node<T> nextRef;
    /**
     * Constructors to initialize the instance variables
     */
    public Node(){
        value=null;
        nextRef=null;
    }
    /**
     * Parameterized Constructors to initialize instance and
     * local variables
     *
     * @param data the data to store in the node of a linked list
     * @param next the address of the next node
     */
    public Node(T data, Node<T> next){
        this.value=data;
        this.nextRef=next;
    }
    /**
     * Getter method to get the data
     *
     * @return
     */
    public T getValue() {

        return value;
    }
    /**
     * Setter method to set the data
     *
     * @param data the data to be set
     */

    public void setValue(T value) {
        this.value = value;
    }
    /**
     * Getter Method to get the address of the previous node
     *
     * @return the address of the previous node
     */
    public Node<T> getNextRef() {
        return nextRef;
    }
    /**
     * Setter Method to get the address of the previous node
     *
     * @return the address of the previous node
     */
    public void setNextRef(Node<T> ref) {
        this.nextRef = ref;
    }
}
