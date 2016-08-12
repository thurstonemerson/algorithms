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
		public boolean visited = false;
		public Node[] children = new Node[]{};
		public Node(int data){
			this.data = data;
		}
	}
	
	//depth first search is preorder search, visit node first then deep traverse all branches
	public static void depthFirstSearch(Node node){
		
		visit(node);
		
		for (Node child : node.children){
			if (child.visited == false){
				depthFirstSearch(child);
			}
		}
		
	}
	
	public static void visit(Node node){
		System.out.println(node.data);
		node.visited = true;
	}
	
	public static void main(String args[]){
		
		Node root = new Node(0);
		Node one = new Node(1);
		Node four = new Node(4);
		Node five = new Node(5);
		Node three = new Node(3);
		Node two = new Node(2);
		root.children = new Node[]{one, four, five};
		one.children = new Node[]{three, four};
		two.children = new Node[]{one};
		three.children = new Node[]{two, four};
		depthFirstSearch(root);
	}
	
	
}
