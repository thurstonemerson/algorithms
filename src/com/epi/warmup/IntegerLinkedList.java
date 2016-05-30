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

//Linked Lists: Implement a doubly linked list of integers class. 
//Write a reverse method for your list class
public class IntegerLinkedList {

	private Node head;
	private Node tail;

	public IntegerLinkedList() {
		head = null;
		tail = null;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void addFirst(int data) {
		Node newNode = new Node(data);
		if (!isEmpty()) {
			newNode.next = head;
			head.previous = newNode;

		}
		head = newNode;
	}

	public void addLast(int data) {

	}

	public void addAfter(int data) {

	}

	public String toString() {
		StringBuilder list = new StringBuilder("");
		Node current = head;
		while (current != null) {
			list.append(current.data);
			current = current.next;
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

		//test add first
		IntegerLinkedList list = new IntegerLinkedList();
		list.addFirst(1);
		
		//check that can add one item at the beginning
		assert(list.toString().equals("1"));
		
		list.addFirst(2);
		list.addFirst(3);
		
		//check a list of items are inserted at the beginning
		assert(list.toString().equals("321"));
		
		
	}
}