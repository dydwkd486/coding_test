import sys

input = sys.stdin.readline

n = int(input())
result=1
for i in range(n):
    n,m=list(map(int,input().split()))
    if n==result:
        result=m
    elif m==result:
        result=n
print(result)
