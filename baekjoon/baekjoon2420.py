import sys
input = sys.stdin.readline
n,m = list(map(int,input().split()))
result=n-m
print(max(result,-result))