'''
The programming exercises in EPI are representative of what you will be asked
in an interview. We do not provide textbook-style review questions.
  
We present a small set of programming exercises suitable
for someone who needs to review basics. (You are unlikely to be asked these
questions - their purpose is to bootstrap reading EPI.)

When you write your solutions to these exercises, please code to the
following constraints:
 
- Do not use library calls. 
- Do not try to design clever solutions. (This means it is fine to use brute-force approaches.) 
- Assume valid inputs, and ignore internal errors like overflow, IO exceptions, etc. 
- Write unit tests for your programs. 
- Analyze your programs for time and space complexity.
 
@author: Jessica
'''

'''Binary Trees: Write inorder, preorder and postorder traversal methods for a binary tree. (You will need
to implement a class suitable for representing binary trees, but do not need to implement
add, lookup, delete, etc. methods.)'''

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.root = None

'''In-order traversal is where the left branch is traversed first, then the node is visited, then the 
right branch is traversed'''
def inorder_traversal(node, nodes):
    if node is not None:
        inorder_traversal(node.left, nodes)
        nodes.append(node.data)
        inorder_traversal(node.right, nodes)
        
'''Pre-order traversal is where the node is visited first, then the left branch is traversed, followed 
by the right branch'''
def preorder_traversal(node, nodes):
    if node is not None:
        nodes.append(node.data)
        preorder_traversal(node.left, nodes)
        preorder_traversal(node.right, nodes)
        
'''Post-order traversal is where the left branch is traversed, followed  by the right branch,
finally the node is visited'''
def postorder_traversal(node, nodes):
    if node is not None:
        postorder_traversal(node.left, nodes)
        postorder_traversal(node.right, nodes)
        nodes.append(node.data)

if __name__ == "__main__":
    
    nodes = []
    
    tree = BinaryTree()
    tree.root = Node(1)
    tree.root.left = Node(2)
    tree.root.right = Node(3)
    tree.root.left.left = Node(4)
    tree.root.left.right = Node(5)
    
    inorder_traversal(tree.root, nodes)
    print nodes
    assert(nodes == [4, 2, 5, 1, 3])
    nodes = []
    
    preorder_traversal(tree.root, nodes)
    print nodes
    assert(nodes == [1, 2, 4, 5, 3])
    nodes = []
    
    postorder_traversal(tree.root, nodes)
    print nodes
    assert(nodes == [4, 5, 2, 3, 1])
     
     
    