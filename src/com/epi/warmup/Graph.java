package com.epi.warmup;

public class Graph {
//	Graphs: Implement Depth First Search and Breadth First Search. (You will need to implement
//			classes suitable to representing graphs.)
	public Node root = null;
	
	public Graph(Node root){
		this.root = root;
	}
	
	public static class Node {
		public int data;
		public Node[] children;
		public Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String args[]){
		
	}
	
	
}
