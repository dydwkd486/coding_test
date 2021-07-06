import sys
from collections import deque


n= int(input())
result=deque()
for i in range(n):
    temp=int(sys.stdin.readline())
    if temp==0 and len(result)!=0:
        result.pop()
    else:
        result.append(temp)

print(sum(result))