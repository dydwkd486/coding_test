import sys

input= sys.stdin.readline
n,m= map(int,input().split())
result = {}
for i in range(n):
    k,v= input().strip().split(" ")
    result[k]=v
for i in range(m):
    k = input().strip()
    print(result[k])