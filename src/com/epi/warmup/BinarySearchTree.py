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

'''   BSTs: Write a program that searches a BST on integer keys for a given value. (You will need to
           implement a class suitable for representing BSTs, but do not need to implement
           add, lookup, delete, etc. methods.)'''

class Node:
    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data
        
class BinarySearchTree:
    def __init__(self):
        self.root = None
        
    def search(self, current_node, key):
        #case where key is found or current node is null (no key found in tree)
        if current_node is None or current_node.data == key:
            if current_node is not None:
                print "Found node with data {0}".format(current_node.data)
            return current_node 
        
        #search further in the left or right branches
        if current_node.data < key:
            return self.search(current_node.right, key)
        else:
            return self.search(current_node.left, key)
        
        
if __name__ == "__main__":
    tree = BinarySearchTree()
    tree.root = Node(8)
    tree.root.left = Node(3)
    tree.root.right = Node(10)
    tree.root.left.right = Node(6)
    tree.root.left.left = Node(1)
    tree.root.right.right = Node(14) 
    
    assert(tree.search(tree.root, 10) == tree.root.right)
    assert(tree.search(tree.root, 10) != tree.root.left)
    assert(tree.search(tree.root, 14) == tree.root.right.right)



    