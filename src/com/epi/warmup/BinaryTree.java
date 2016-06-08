package com.epi.warmup;


class Node {
	public Node left = null;
	public Node right = null;
	public int data;
	
	public Node(int data){
		this.data = data;
	}
}

public class BinaryTree {
	
	public Node root = null;
	public static StringBuilder nodes = new StringBuilder();
	
	//inorder traversal visits the left branch, visits the node, then the right branch
	public static void inorderTraversal(Node currentNode){
		if (currentNode != null){
			inorderTraversal(currentNode.left);
			nodes.append(currentNode.data);
			inorderTraversal(currentNode.right);
		}
	}
	
	//preorder traversal visits the node first, then the left branch followed by the right branch
	public static void preorderTraversal(Node currentNode){
		if (currentNode != null){
			nodes.append(currentNode.data);
			preorderTraversal(currentNode.left);
			preorderTraversal(currentNode.right);
		}
	}
	
	public static void postorderTraversal(Node currentNode){
//		if (currentNode != null){
//			inorderTraversal(currentNode.left);
//			nodes.append(currentNode.data);
//			inorderTraversal(currentNode.right);
//		}
	}
	
	
//	Binary Trees: Write inorder, preorder and postorder traversal methods for a binary tree. (You will need
//	to implement a class suitable for representing binary trees, but do not need to implement
//	add, lookup, delete, etc. methods.)
	public static void main(String []args){
		
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		inorderTraversal(tree.root);
		System.out.println(nodes.toString());
		assert(nodes.toString().equals("42513"));
		nodes = new StringBuilder();
		
		preorderTraversal(tree.root);
		System.out.println(nodes.toString());
		assert(nodes.toString().equals("12453"));
		nodes = new StringBuilder();

//		
//		inorderTraversal(tree.root);
//		assert(nodes.toString().equals("42513"));
//		nodes = new StringBuilder();

	}
}

