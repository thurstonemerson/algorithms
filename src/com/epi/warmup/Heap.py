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


'''  Heaps: Write a program that builds a max-heap from an integer array. (You will need to implement
a class suitable for representing heaps, but do not need to implement extract-max, insert key, etc.) '''


class Heap:
    def __init__(self, a):
        self.max_heap = a
        
        for i in range(len(self.max_heap)/2 - 1, -1, -1):
            self.heapify(i)
        
    def heapify(self, i):
        print ("calling heapify with index {0} {1}".format(i, self.max_heap[i]))
        left_index = (i*2)+1
        right_index = left_index+1
        max = i
        
        #if (i < len(self.max_heap) and self.max_heap[max] > self.max_heap[max]):

    def display(self):
        for i in range(len(self.max_heap)):
            print self.max_heap[i]

if __name__ == "__main__":
    a = [2, 5, 10, 15, 19, 20, 30, 50]
    heap = Heap(a)
    heap.display()
   