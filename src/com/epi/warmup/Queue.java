package com.epi.warmup;

import java.util.EmptyStackException;

public class Queue {
	
	private QueueNode top = null;
	private QueueNode bottom = null;

	public Queue() {
	}

	private class QueueNode {
		public int data;
		public QueueNode next;

		public QueueNode(int data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return (bottom == null);
	}

	//add an item to the top of the queue
	public void add(int data) {
		QueueNode newNode = new QueueNode(data);
		newNode.next = null;
		
		//point previous top to new node
		if (top != null){
			top.next = newNode;
		} 
		top = newNode;
		
		//set bottom to the first item added
		if (bottom == null){
			bottom = newNode;
		}
	}

	//remove an item from the bottom of the queue
	public int remove() {
		if (isEmpty()) throw new EmptyStackException();
		int data = bottom.data;
		bottom = bottom.next;
		return data;
	}
	

	public static void main(String args[]) {

		//test queue implementation
		Queue queue = new Queue();
		queue.add(3);
		queue.add(2);
		queue.add(1);
		
		assert(queue.remove() == 3);
		assert(queue.remove() == 2);
		assert(queue.remove() == 1);
		assert(queue.isEmpty() == true);
		
	}
}
