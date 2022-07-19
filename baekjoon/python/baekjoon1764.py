import sys
from collections import deque

a={}
b={}
result=deque()
n,m=list(map(int,sys.stdin.readline().split()))
# print(n,m)

for i in range(n):
    a[sys.stdin.readline().split()[0]]=i
for i in range(m):
    b[sys.stdin.readline().split()[0]]=i

# print(a.items(),b)
for i,_ in a.items():
    try:
        b[i]
        result.append(i)
    except KeyError:
        pass
result=sorted(result)
print(len(result))
for i in result:
    print(i)
