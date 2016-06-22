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

'''Hash tables: Write a program that finds the most common object in an
array of objects. The objects consists of pairs of strings. Treat strings as being the same if
they are equal when converted to lower case.  '''

class ArrayObject:
    
    def __init__(self, str1, str2):
        self.str1 = str1
        self.str2 = str2
        
    def __hash__(self):
        return hash((self.str1, self.str2))
    
    def __eq__(self, other):
        if not isinstance(other, ArrayObject) or other is None:
             return False
         
        str1Match, str2Match = False, False 
         
        if other.str1 is None and self.str1 is None:
            str1Match = True
        
        if other.str2 is None and self.str2 is None:
            str2Match = True
            
        if other.str1 is not None and self.str1 is not None and other.str1 == self.str1:
            str1Match = True
            
        if other.str2 is not None and self.str2 is not None and other.str2 == self.str2:
            str2Match = True
        
        return str1Match and str2Match
        
    def __ne__(self, other):
        if not isinstance(ArrayObject, other) or other is None:
             return False
         
        str1NotMatch, str2NotMatch = True 
         
        if other.str1 is None and self.str1 is None:
            str1NotMatch = False
        
        if other.str2 is None and self.str2 is None:
            str2NotMatch = False
            
        if other.str1 is not None and self.str1 is not None and other.str1 == self.str1:
            str1NotMatch = False
            
        if other.str2 is not None and self.str2 is not None and other.str2 == self.str2:
            str2NotMatch = False
        
        return str1NotMatch or str2NotMatch
    
    
def mostcommonobject(a):
    
    dict = {}
    
    for obj in a:
        print ("{0}, {1}".format(obj.str1, obj.str2))
        count = dict.get(obj)
        
        if count is None:
            count = 1
        else:
            count = count + 1
            
        dict[obj] = count
        
    for key in dict:
        print ("object {0}{1} has count {2} ".format(key.str1, key.str2, dict[key]))
        
    
      
        

if __name__ == "__main__":
    
    obj1 = ArrayObject("hello", "ick");
    obj2 = ArrayObject("hello", "ick");
    obj3 = ArrayObject("", "ick");
    obj4 = ArrayObject("ff", "asdf");
    obj5 = ArrayObject("ff", "asdf");
    obj6 = ArrayObject(None, None);
    obj7 = ArrayObject("hello", "ick");
    
    a = [obj1, obj2, obj3, obj4, obj5, obj6, obj7]
    mostcommonobject(a)

