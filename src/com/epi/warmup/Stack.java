package com.epi.warmup;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Stack {
	// Stacks and Queues: Write a program to evaluate arithmetical expressions
	// that use + and applied to nonnegative integer arguments. Expressions are
	// in reverse-Polish notation, e.g., 3 4 + 5 , 1 3 + 5 7 + *.
	
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
	// this has a big O time complexity of O(1)
	public void push(int data) {
		StackNode newNode = new StackNode(data);
		newNode.next = top;
		top = newNode;
	}

	// pop off the top of the stack
	// this has a big O time complexity of O(1)
	public int pop() {
		if (isEmpty()) throw new EmptyStackException();
		int data = top.data;
		top = top.next;
		return data;
	}
	
	//pass in a reverse polish notation string and evaluate it
	// This has a big O time complexity of O(n) where n is the number
	// of operators/operands in the expression.
	// Space complexity is O(n) as well, as there is around about one
	// node for every item in the expression.
	public static int evaluateExpression(String expression){
		
		//4 2 5 * + / 3 2 * + /
		Stack stack = new Stack();
		
		//parse expression into a list
		String[] tokens = expression.split(" ");
		
		for (String token : tokens){
			System.out.println("processing token " + token);
			if (isOperator(token)){
				int secondOperand = stack.pop();
				int firstOperand = stack.pop();
				stack.push(evaluate(token, firstOperand, secondOperand));
			} else {
				stack.push(Integer.valueOf(token));
			}
		}
		
		int result = stack.pop();
		System.out.println("result is " + result);
		return result;
	}
	
	public static boolean isOperator(String token){
		if (token.equals("*")|| token.equals("+")||token.equals("-")||token.equals("/")){
			return true;
		}
		return false;
	}
	
	
	
	public static int evaluate(String operator, int firstOperand, int secondOperand){
		
		if (operator.equals("*")){ 
			return firstOperand * secondOperand;
		}
		
		if (operator.equals("+")){ 
			return firstOperand + secondOperand;
		}
		
		if (operator.equals("-")){ 
			return firstOperand - secondOperand;
		}
		
		//what will happen if the answer is not an int?
		if (operator.equals("/")){ 
			return firstOperand / secondOperand;
		}
		
		throw new NoSuchElementException("Token is not an operator");
	}
	

	public static void main(String args[]) {

		//test stack implementation
		Stack stack = new Stack();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		
		assert(stack.pop() == 1);
		assert(stack.pop() == 2);
		assert(stack.pop() == 3);
		assert(stack.isEmpty() == true);
		
		String expression = "4 2 5 * + 3 2 1 * + /";
		assert(evaluateExpression(expression) == 2);
		
	}
}
