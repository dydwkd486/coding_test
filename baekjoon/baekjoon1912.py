import sys
input= sys.stdin.readline

n = int(input())
node = list(map(int,input().split()))
dp=[0]*n
dp[0] = node[0]

for i in range(1,n):
    dp[i]=max(node[i],dp[i-1]+node[i])

print(max(dp))