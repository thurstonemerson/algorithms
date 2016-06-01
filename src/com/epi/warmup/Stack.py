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

''' Stacks and Queues: Write a program to evaluate arithmetical expressions
    that use + and applied to nonnegative integer arguments. Expressions are
    in reverse-Polish notation, e.g., 3 4 + 5 , 1 3 + 5 7 + *.'''
class Stack:

    def __init__(self):
        self.top = None
        
    def is_empty(self):
        return self.top is None    
    
    '''Push a new item onto the top of the stack '''
    def push(self, data):
        new_node = self.StackNode(data)
        new_node.next = self.top
        self.top = new_node
        
    '''Pop an item off the top of the stack, removing it'''
    def pop(self):
        if self.is_empty():
            raise ValueError("Stack is empty")
        data = self.top.data
        self.top = self.top.next
        print data
        return data

    '''Single node within a stack'''
    class StackNode:
        def __init__(self, data):
            self.data = data
            self.next = None
    

def evaluate_expression(expression):
    return 0

if __name__ == "__main__":
    stack = Stack()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    
    assert(stack.pop() == 3)
    assert(stack.pop() == 2)
    assert(stack.pop() == 1)
    
    