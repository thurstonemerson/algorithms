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

''' 
   Graphs: Implement Depth First Search and Breadth First Search. (You will need to implement
            classes suitable to representing graphs.)'''
            
class Queue:

    def __init__(self):
        self.top = None
        self.bottom = None
        
    def is_empty(self):
        return self.bottom is None    
    
    '''Add a new item into the queue '''
    def add(self, data):
        new_node = self.QueueNode(data)
        if self.top is not None:
            self.top.next = new_node
        self.top = new_node
        if self.bottom is None:
            self.bottom = new_node
        
    '''Remove the bottom queue item'''
    def remove(self):
        if self.is_empty():
            raise ValueError("Queue is empty")
        data = self.bottom.data
        self.bottom = self.bottom.next
        if self.bottom is None:
            self.top = None
        return data

    '''Single node within a stack'''
    class QueueNode:
        def __init__(self, data):
            self.data = data
            self.next = None

class Node:
    def __init__(self, data):
        self.neighbours = None
        self.data = data
        self.marked = False

def depth_first_search(node):
    
    visit(node)
    
    if node.neighbours is None:
        return
    
    for neighbour in node.neighbours:
        if neighbour.marked is False:
            depth_first_search(neighbour)
            
            
def breadth_first_search(root):
    queue = Queue()
    queue.add(root)
    root.marked = True
    
    while (queue.is_empty() is False):
        node = queue.remove()
        visit(node)
        if node.neighbours is not None:
            for neighbour in node.neighbours:
                if neighbour.marked is False:
                    neighbour.marked = True
                    queue.add(neighbour)


def visit(node):
    node.marked = True
    print node.data
    
def test_DFS():
    zero = Node(0)
    one = Node(1)
    two = Node(2)
    three = Node(3)
    four = Node(4)
    five = Node(5)
    six = Node(6)
    
    zero.neighbours = [one, four, five]
    one.neighbours = [three, four]
    two.neighbours = [one]
    three.neighbours = [two, four]
    five.neighbours = [six]
    
    depth_first_search(zero)
    
def test_BFS():
    zero = Node(0)
    one = Node(1)
    two = Node(2)
    three = Node(3)
    four = Node(4)
    five = Node(5)
    six = Node(6)
    
    zero.neighbours = [one, four, five]
    one.neighbours = [three, four]
    two.neighbours = [one]
    three.neighbours = [two, four]
    five.neighbours = [six]
    
    breadth_first_search(zero)
 
if __name__ == "__main__":
   
    test_DFS()
    test_BFS()
    
    
    
            
            
