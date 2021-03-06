/**
 * The programming exercises in EPI are representative of what you will be asked
 * in an interview. We do not provide textbook-style review questions.
 * 
 * We present a small set of programming exercises suitable for someone who
 * needs to review basics. (You are unlikely to be asked these questions - their
 * purpose is to bootstrap reading EPI.)
 * 
 * When you write your solutions to these exercises, please code to the
 * following constraints:
 * 
 * - Do not use library calls. - Do not try to design clever solutions. (This
 * means it is fine to use brute-force approaches.) - Assume valid inputs, and
 * ignore internal errors like overflow, IO exceptions, etc. - Write unit tests
 * for your programs. - Analyze your programs for time and space complexity.
 * 
 * @author Jessica
 * 
 */
package com.epi.warmup;

import java.util.NoSuchElementException;

//Linked Lists: Implement a doubly linked list of integers class. 
//Write a reverse method for your list class
public class DoublyLinkedList {

	private Node head;
	private Node tail;

	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}
	
	//reverse the linked list
	//This has a time complexity of O(n) as we have to loop
	//through the list swapping all the next/previous pointers
	public void reverse(){
		Node current = head;
		
		while (current != null){
			//swap the previous and next pointers
			Node tmp = current.next;
			current.next = current.previous;
			current.previous = tmp;
			current = current.previous;
		}
		//swap the head and tail
		Node tmp = head;
		head = tail;
		tail = tmp;
	}
	
	public int getFirst(){
		if (isEmpty())
			throw new NoSuchElementException("List is empty"); 
		return head.data;
	}
	
	public int getLast(){
		if (isEmpty())
			throw new NoSuchElementException("List is empty"); 
		return tail.data;
	}
	
	//Add a data node to the top of the list
	//This has a time complexity of O(1)
	public void addFirst(int data) {
		Node newNode = new Node(data);
		if (!isEmpty()) {
			newNode.next = head;
			head.previous = newNode;
		} else {
			tail = newNode;
		}
		head = newNode;
	}

	//Add a data node to the end of the list
	//This has a time complexity of O(1)
	public void addLast(int data) {
		Node newNode = new Node(data);
		if (!isEmpty()) {
			newNode.previous = tail;
			tail.next = newNode;
		} else {
			head = newNode;
		}
		tail = newNode;
	}

	//Add a data node to the top of the list
	//This has a time complexity of O(n) as we have
	//to loop through the list to find the key
	public boolean addAfter(int key, int data) {

		//find key
		Node current = head;
		Node keyNode = null;
		
		while(current != null){
			if (current.data == key){
				keyNode = current;
			}
			current = current.next;
		}
		
		//if key node is null, then key wasn't found
		if (keyNode == null){
			return false;
		}
		
		//otherwise insert the key after the key node
		addAfter(keyNode, data);
		return true;
	}
	
	public void addAfter(Node key, int data) {
		Node newNode = new Node(data);
		
		newNode.next = key.next;
		
		if (key != tail){
			newNode.next.previous = newNode;
			key.next = newNode;
			newNode.previous = key;
		} else {//if key was the tail, point the tail to the new node
			key.next = newNode;
			newNode.previous = key;
			tail = newNode;
		}
	}

	public String printFromHead() {
		StringBuilder list = new StringBuilder("");
		Node current = head;
		while (current != null) {
			list.append(current.data);
			current = current.next;
		}
		System.out.println(list.toString());
		return list.toString();
	}

	public String printFromTail() {
		StringBuilder list = new StringBuilder("");
		Node current = tail;
		while (current != null) {
			list.append(current.data);
			current = current.previous;
		}
		System.out.println(list.toString());
		return list.toString();
	}

	public class Node {
		Node next = null;
		Node previous = null;
		int data;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String args[]) {

		// test add first
		DoublyLinkedList list = new DoublyLinkedList();
		list.addFirst(1);

		// check that can add one item at the beginning
		assert (list.printFromHead().equals("1"));
		assert (list.printFromTail().equals("1"));

		list.addFirst(2);
		list.addFirst(3);

		// check a list of items are inserted at the beginning
		assert (list.printFromHead().equals("321"));
		assert (list.printFromTail().equals("123"));

		// test add last
		list = new DoublyLinkedList();
		list.addLast(1);

		// check that can add one item at the end
		assert (list.printFromHead().equals("1"));
		assert (list.printFromTail().equals("1"));
		
		list.addLast(2);
		list.addLast(3);

		// check a list of items are inserted at the beginning
		assert (list.printFromHead().equals("123"));
		assert (list.printFromTail().equals("321"));
		
		//check can add an item in the middle
		list = new DoublyLinkedList();
		list.addFirst(1);
		list.addLast(3);

		assert (list.printFromHead().equals("13"));
		assert (list.printFromTail().equals("31"));
		
		list.addAfter(1, 2);
		assert (list.printFromHead().equals("123"));
		assert (list.printFromTail().equals("321"));
		assert (list.getFirst() == 1);
		assert (list.getLast() == 3);
		
		//check that returns false if key not found
		assert (list.addAfter(6, 2) == false);
		
		//check that tail is correctly pointing to the end after insertion at end
		list.addAfter(3, 4);
		assert (list.printFromHead().equals("1234"));
		assert (list.printFromTail().equals("4321"));
		
		//reverse the list
		list.reverse();
		assert (list.printFromTail().equals("1234"));
		assert (list.printFromHead().equals("4321"));
		
		//check tail and head are correct
		assert (list.getFirst() == 4);
		assert (list.getLast() == 1);

	}
}