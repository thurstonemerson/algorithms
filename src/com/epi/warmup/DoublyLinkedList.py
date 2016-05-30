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
class Node:
    def __init__(self, data):
        self.data = data
        self.previous = None
        self.next = None
            
class DoublyLinkedList:
    
    def __init__(self):
        self.head = None
        self.tail = None
        
    def is_empty(self):
        if self.head is None:
            return True
        return False
    
#     '''Reverse the list'''
#     def reverse(self):
#         
#         current = self.head
#         
#         while current is not None:
            
              
    '''Add a node at the front of the linked list'''
    def add_first(self, data):
        
        new_node = Node(data)
        
        if self.is_empty():
            self.tail = new_node
        else:
            new_node.next = self.head
            self.head.previous = new_node
        
        new_node.previous = None
        self.head = new_node
        
    '''Return a string of list items from head to tail'''
    def get_list_head_first(self):
        
        items = []
        current = self.head
        
        while current is not None:
            items.append(str(current.data))
            current = current.next
        
        str_items = "".join(items)
        print str_items
        return str_items
    
    '''Return a string of list items from tail to head'''
    def get_list_tail_first(self):
        
        items = []
        current = self.tail
        
        while (current is not None):
            items.append(str(current.data))
            current = current.previous
        
        str_items = "".join(items)
        print str_items
        return str_items
    

if __name__ == "__main__":
    list = DoublyLinkedList()
    list.add_first(1)
    
    assert(list.get_list_head_first() == "1")
    assert(list.get_list_tail_first() == "1")
    
    list.add_first(2)
    list.add_first(3)
    
    assert(list.get_list_head_first() == "321")
    assert(list.get_list_tail_first() == "123")
    