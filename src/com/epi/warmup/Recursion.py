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

'''Write a recursive program that takes as input positive integers x and N, 
and returns x to the power N.
You should use O(log N) multiplications.  '''

def power(x, n):
    
    if n == 0:
        print "{0}^{1}={2}".format(x, n, 1)
        return 1
    
    total = power(x, n/2)
    
    if n%2 == 0:
        print "{0}^{1}={2}".format(x, n, total * total)
        return total * total
    
    print "{0}^{1}={2}".format(x, n, total * total * x)
    return total * total * x
    
if __name__ == "__main__":
    
    assert(power(2, 8) == 256)
    assert(power(2, 7) == 128)


  
   