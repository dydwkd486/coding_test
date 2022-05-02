import sys

input= sys.stdin.readline

dp=[0]*103

dp[0] = 1
dp[1] = 1
dp[2] = 1

for i in range(3,len(dp)):
    dp[i]=dp[i-2]+dp[i-3]

n = int(input())

for i in range(n):
    temp=int(input())
    print(dp[temp-1])