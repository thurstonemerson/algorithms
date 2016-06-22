package com.epi.warmup;

public class BinarySearchTree {
//	BSTs: Write a program that searches a BST on integer keys for a given value. (You will need to
//			implement a class suitable for representing BSTs, but do not need to implement
//			add, lookup, delete, etc. methods.)
	
	public Node root = null;
	
	public BinarySearchTree(Node root){
		this.root = root;
	}
	
	public static Node search(Node currentNode, int key){
		if (currentNode == null || currentNode.data == key)
			return currentNode;
		
		//search either the left branch or the right branch
		if (currentNode.data < key){
			return search(currentNode.right, key);
		} else {
			return search(currentNode.left, key);
		}
	}
	
	
	public static class Node {
		public Node left = null;
		public Node right = null;
		public int data = 0;
		
		public Node(int data){
			this.data = data;
		}
	}
	
	public static void main(String args[]){
		
		Node root = new BinarySearchTree.Node(8);
		root.left = new BinarySearchTree.Node(3);
		root.right = new BinarySearchTree.Node(10);
		root.left.left = new BinarySearchTree.Node(1);
		root.left.right = new BinarySearchTree.Node(6);
		root.right.right = new BinarySearchTree.Node(14);
		
		assert(search(root, 1).equals(root.left.left));
		
	}
	
	
}
