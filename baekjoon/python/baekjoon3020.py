import sys

import sys

input = sys.stdin.readline

n,h= list(map(int,input().split()))

up=[0]*(h+1)
down=[0]*(h+1)

min_count=n
count=0

for i in range(n):
    temp=int(input())
    if i%2==0:
        up[temp]+=1
    else:
        down[temp]+=1

for i in range(h-1,0,-1):
    up[i]+=up[i+1]
    down[i]+=down[i+1]

for i in range(1,h+1):
    if min_count > up[i]+down[h-i+1]:
        min_count=up[i]+down[h-i+1]
        count=1
    elif min_count==up[i]+down[h-i+1]:
        count+=1
print(min_count,count)



