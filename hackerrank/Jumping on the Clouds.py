#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'jumpingOnClouds' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY c as parameter.
#

def jumpingOnClouds(c):
    index=0
    result=0
    # Write your code here
    
    while True:
        if index==len(c)-2 or index==len(c)-1:
            if index==len(c)-1:
                break
            else:
                if c[index]==0:
                    result+=1
                    index+=1
        else:
            if c[index+2]==0:
                index+=2
                result+=1
            else:
                index+=1
                result+=1
    # print(result)
    return result
        
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    c = list(map(int, input().rstrip().split()))

    result = jumpingOnClouds(c)

    fptr.write(str(result) + '\n')

    fptr.close()