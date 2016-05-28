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

#Strings: Write a program to find the longest substring that consists of a
#single character in an input string.
def find_longest_substring(input):
    
    longest_substring= ""
    
    for i in range(len(input)):
        for j in range(i+1, len(input)+1):
            substring = input[i:j]
            if is_repeating_char(substring) and len(substring) >= len(longest_substring):
                longest_substring = substring
    
    print "the longest substring is %s"%longest_substring
    return longest_substring

def is_repeating_char(str):
    
    first_char = str[:1]
    
    #if one of the characters doesn't equal the first one, chars are not repeated
    for i in range(1, len(str)):
        if first_char != str[i:i+1]:
            return False
    
    return True


if __name__ == "__main__":
    
    str = "a"
    assert(find_longest_substring(str) == "a")
     
    str = "abbccc"
    assert(find_longest_substring(str) == "ccc")
    
    str = "abbcccddd"
    assert(find_longest_substring(str) == "ddd")
    
    