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

''' Searching: Write a nonrecursive program to perform binary search over a sorted array. '''
def search(a, key):
    
    left = 0
    right = len(a)-1
    
    while (left <= right):
        mid = left + (right - left)/2
        
        if (a[mid] == key):
            print ("found key {0} at index {1}".format(a[mid], mid))
            return mid
        
        if (a[mid] > key):
            right = mid - 1
        else:
            left = mid + 1
    
    print ("Didn't find key {0}".format(key))
    return -1

if __name__ == "__main__":
    a = []
    
    assert(search(a, 4) == -1)
    
    a = [0, 1, 4, 5, 8, 10]
    
    assert(search(a, 4) == 2)
    assert(search(a, 10) == 5)
    assert(search(a, 7) == -1)
    