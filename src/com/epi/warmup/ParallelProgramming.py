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
Parallel Computing: Write a program which uses two threads to print the numbers from
1 to 100 in order. One thread can only print odd numbers, the other can only print even numbers.
'''

import threading

current = 1
lock = threading.Lock()
max = 10

class PrintEven(threading.Thread):
    def run(self):
        while(True):
            lock.acquire()
            if current > max:
                return
            if (current % 2 == 0):
                print current
                current=current+1
            lock.release()
        
class PrintOdd(threading.Thread):
    def run(self):
        while(True):
            lock.acquire()
            if current > max:
                return
            if (current % 2 != 0):
                print current
                current=current+1
            lock.release()

if __name__ == "__main__":
    printEven = PrintEven()
    printOdd = PrintOdd()
    
    printEven.start()
    printOdd.start()
    
   
