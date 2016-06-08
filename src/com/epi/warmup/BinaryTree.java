package com.epi.warmup;
/**
 * The programming exercises in EPI are representative of what you will be asked
 * in an interview. We do not provide textbook-style review questions.
 * 
 * We present a small set of programming exercises suitable for someone who
 * needs to review basics. (You are unlikely to be asked these questions - their
 * purpose is to bootstrap reading EPI.)
 * 
 * When you write your solutions to these exercises, please code to the
 * following constraints:
 * 
 * - Do not use library calls. - Do not try to design clever solutions. (This
 * means it is fine to use brute-force approaches.) - Assume valid inputs, and
 * ignore internal errors like overflow, IO exceptions, etc. - Write unit tests
 * for your programs. - Analyze your programs for time and space complexity.
 * 
 * @author Jessica
 * 
 */

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
	
	//postorder traversal traverses the left branch followed by the right branch, then visits the node
	public static void postorderTraversal(Node currentNode){
		if (currentNode != null){
			postorderTraversal(currentNode.left);
			postorderTraversal(currentNode.right);
			nodes.append(currentNode.data);
		}
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

		postorderTraversal(tree.root);
		System.out.println(nodes.toString());
		assert(nodes.toString().equals("45231"));
	}
}

