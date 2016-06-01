package com.epi.warmup;

import java.util.EmptyStackException;

public class Stack {
	// Stacks and Queues: Write a program to evaluate arithmetical expressions
	// that use + and applied to nonnegative integer arguments. Expressions are
	// /in reverse-Polish notation, e.g., 3 4 + 5 , 1 3 + 5 7 + *.
	private StackNode top = null;

	public Stack() {
	}

	private class StackNode {
		public int data;
		public StackNode next;

		public StackNode(int data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return (top == null);
	}

	// push a value onto the stack
	public void push(int data) {
		StackNode newNode = new StackNode(data);
		newNode.next = top;
		top = newNode;
	}

	// pop off the top of the stack
	public int pop() {
		if (isEmpty()) throw new EmptyStackException();
		int data = top.data;
		top = top.next;
		return data;
	}

	public static void main(String args[]) {

		Stack stack = new Stack();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		assert(stack.pop() == 1);
		assert(stack.pop() == 2);
		assert(stack.pop() == 3);
		assert(stack.isEmpty() == true);
		
	}
}
