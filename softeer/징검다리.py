import sys

input = sys.stdin.readline

n = int(input())

dp = [1 for _ in range(n)]

a = list(map(int,input().split()))

for i in range(n):
    temp=0
    for j in range(i):
        if a[j]<a[i]:
            if temp<=dp[j]:
                temp=dp[j]
    dp[i]=temp+1

print(max(dp))