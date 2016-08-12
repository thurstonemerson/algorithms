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
	
	public static void depthFirstSearch(Node node){
		
	}
	
	public static void main(String args[]){
		
		Node root = new Node(0);
		Node one = new Node(1);
		Node four = new Node(4);
		Node five = new Node(5);
		Node three = new Node(5);
		Node two = new Node(5);
		root.children = new Node[]{one, four, five};
		one.children = new Node[]{two, three, four};
		three.children = new Node[]{two, four};
		depthFirstSearch(root);
	}
	
	
}
