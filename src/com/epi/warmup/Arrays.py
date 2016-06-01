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

''' Arrays: Write a program that tests if a 2D square array is symmetric
   about the diagonal from (0,0) to (n-1,n-1). '''
def check_symmetric(array):

    for row in range(len(array)):
        for col in range(len(array[row])):
            if array[row][col] != array[col][row]:
                return False
    
    return True
    
if __name__ == '__main__':
   
   symmetric_array = [[1, 2, 3, 4],[2, 1, 2, 3],[3, 2, 1, 2],[4, 3, 2, 1]]
   non_symmetric_array = [[1, 2, 3, 5],[2, 1, 2, 3],[3, 2, 1, 2],[4, 3, 2, 1]]
   
   assert(check_symmetric(symmetric_array) == True)
   assert(check_symmetric(non_symmetric_array) == False)
  
   