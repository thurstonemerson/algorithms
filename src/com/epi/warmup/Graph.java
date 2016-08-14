package com.epi.warmup;

public class Graph {
	// Graphs: Implement Depth First Search and Breadth First Search. (You will
	// need to implement
	// classes suitable to representing graphs.)
	public Node root = null;

	public Graph(Node root) {
		this.root = root;
	}

	public static class Node {
		public int data;
		public boolean marked = false;
		public Node[] children = new Node[] {};

		public Node(int data) {
			this.data = data;
		}
	}

	// depth first search is preorder search, visit node first then deep
	// traverse all branches
	public static void depthFirstSearch(Node node) {

		visit(node);

		for (Node child : node.children) {
			if (child.marked == false) {
				depthFirstSearch(child);
			}
		}

	}

	public static void breadthFirstSearch(Node root) {
		Queue<Node> queue = new Queue<Node>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node node = queue.remove();
			visit(node);

			for (Node child : node.children) {
				if (child.marked == false) {
					queue.add(child);
					child.marked = true;
				}
			}
		}
	}

	public static void visit(Node node) {
		System.out.println(node.data);
		node.marked = true;
	}

	public static void testDepthFirst() {
		Node root = new Node(0);
		Node one = new Node(1);
		Node four = new Node(4);
		Node five = new Node(5);
		Node three = new Node(3);
		Node two = new Node(2);
		Node six = new Node(6);
		root.children = new Node[] { one, four, five };
		one.children = new Node[] { three, four };
		two.children = new Node[] { one };
		three.children = new Node[] { two, four };
		five.children = new Node[] { six };
		depthFirstSearch(root); // should print 0, 1, 3, 2, 4, 5, 6
	}

	public static void testBreadthFirst() {
		Node root = new Node(0);
		Node one = new Node(1);
		Node four = new Node(4);
		Node five = new Node(5);
		Node three = new Node(3);
		Node two = new Node(2);
		Node six = new Node(6);
		root.children = new Node[] { one, four, five };
		one.children = new Node[] { three, four };
		two.children = new Node[] { one };
		three.children = new Node[] { two, four };
		five.children = new Node[] { six };
		breadthFirstSearch(root); // should print 0, 1, 4, 5, 3, 6, 2
	}

	public static void main(String args[]) {

		testDepthFirst();
		testBreadthFirst();

	}

}
