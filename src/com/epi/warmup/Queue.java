package com.epi.warmup;

import java.util.EmptyStackException;

public class Queue<T> {
	
	private QueueNode<T> top = null;
	private QueueNode<T> bottom = null;

	public Queue() {
	}

	private class QueueNode<T>  {
		public T data;
		public QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return (bottom == null);
	}

	//add an item to the top of the queue
	public void add(T data) {
		QueueNode<T> newNode = new QueueNode<T>(data);
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
	public T remove() {
		if (isEmpty()) throw new EmptyStackException();
		T data = bottom.data;
		bottom = bottom.next;
		return data;
	}
	

	public static void main(String args[]) {

		//test queue implementation
		Queue<Integer> queue = new Queue<Integer>();
		queue.add(3);
		queue.add(2);
		queue.add(1);
		
		assert(queue.remove() == 3);
		assert(queue.remove() == 2);
		assert(queue.remove() == 1);
		assert(queue.isEmpty() == true);
		
	}
}
