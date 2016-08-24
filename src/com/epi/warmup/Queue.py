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
class Queue:

    def __init__(self):
        self.top = None
        self.bottom = None
        
    def is_empty(self):
        return self.bottom is None    
    
    
    '''Peek at the first item on the queue'''
    def peek(self):
        if self.is_empty():
            raise ValueError("Queue is empty")
        data = self.bottom.data
        return data
    
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
        

if __name__ == "__main__":
    q = Queue()
    q.add(1)
    q.add(2)
    q.add(3)
    
    assert(q.remove() == 1)
    assert(q.remove() == 2)
    assert(q.peek() == 3)
    assert(q.remove() == 3)
    assert(q.is_empty() == True)
    
    