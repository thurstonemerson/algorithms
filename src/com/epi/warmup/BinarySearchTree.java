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
		if (currentNode == null || currentNode.data == key){
			if (currentNode != null){
				System.out.println("Found node " + currentNode.data);
			}
			return currentNode;
		}
		
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
	
		BinarySearchTree tree = new BinarySearchTree(new BinarySearchTree.Node(8));
		
		tree.root.left = new BinarySearchTree.Node(3);
		tree.root.right = new BinarySearchTree.Node(10);
		tree.root.left.left = new BinarySearchTree.Node(1);
		tree.root.left.right = new BinarySearchTree.Node(6);
		tree.root.right.right = new BinarySearchTree.Node(14);
		
		assert(search(tree.root, 1).equals(tree.root.left.left));
		assert(!search(tree.root, 1).equals(tree.root.left.right));
		assert(search(tree.root, 10).equals(tree.root.right));
		
	}
	
	
}
