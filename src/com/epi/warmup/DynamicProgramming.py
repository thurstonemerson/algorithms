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

''' Dynamic Programming: Write a program that takes a positive integer N, and returns the number
    of binary strings of length N such that there are no consecutive 1s. For example, if N = 3, the result
    is 5, corresponding to the strings 000, 001, 010, 100, 101. '''


def get_number_of_strings(n):
    p0, p1, s0, s1 = 1, 1, 1, 1
    
    for x in range(2, n+1):
        s0 = p0 + p1
        s1 = p0
        p0 = s0
        p1 = s1
        
    return s0 + s1    
    
if __name__ == "__main__":
    assert(get_number_of_strings(1) == 2)
    assert(get_number_of_strings(3) == 5)
    assert(get_number_of_strings(4) == 8)
    
    
    