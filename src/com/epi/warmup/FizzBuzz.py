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


'''   Primitive types: write a program that takes as input an integer, N, and prints
all the integers from 1 to N, replacing numbers divisible by 3 with fizz, numbers divisible by
5 with buzz, and numbers divisible by both with fizz buzz. '''
def get_fizz_buzz(N):

    fizz_buzz = []
    
    for x in range(1, N+1):
        if x%3==0 and x%5==0:
            fizz_buzz.append("fizz buzz")
        elif x%3==0:
            fizz_buzz.append("fizz")
        elif x%5==0:
            fizz_buzz.append("buzz")
        else:
            fizz_buzz.append(str(x))
        
        
    fizz_str = ', '.join(fizz_buzz)   
    print fizz_str 
    return fizz_str
    
if __name__ == '__main__':
    #2 = 1, 2
   assert("1, 2" == get_fizz_buzz(2))
   #3 = 1, 2, fizz
   assert("1, 2, fizz" == get_fizz_buzz(3))
   #5 = 1, 2, fizz, 4, buzz
   assert("1, 2, fizz, 4, buzz" == get_fizz_buzz(5))
   #15 = 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizz buzz 
   assert("1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizz buzz" == get_fizz_buzz(15))
   
   