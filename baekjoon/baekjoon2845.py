import sys

input= sys.stdin.readline

l,p=list(map(int,input().split()))
a=l*p

n = list(map(int,input().split()))
result=[]
for i in n:
    result.append(i-a)

print(*result)