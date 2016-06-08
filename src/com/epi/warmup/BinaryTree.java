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
	
	//inorder traversal visits the left branch, visits the root, then the right branch
	public static String inorderTraversal(Node currentNode){
		StringBuilder nodes = new StringBuilder();
		if (currentNode != null){
			inorderTraversal(currentNode.left);
			nodes.append(currentNode.data);
			inorderTraversal(currentNode.right);
		}
		System.out.println(nodes.toString());
		return nodes.toString();
	}
	
	public static void preorderTraversal(){
		
	}
	
	public static void postorderTraversal(){
		
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
		
		
		assert(inorderTraversal(tree.root).equals("42513"));
	}
}

