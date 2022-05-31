import sys
input = sys.stdin.readline

n=int(input())
dp=[0]*(n+1)
list_n=[0]+list(map(int,input().split()))

for i in range(1,n+1):
    for j in range(1,i+1):
        if dp[i] == 0:
            dp[i]=dp[i-j]+list_n[j]
        else:
            dp[i] = min(dp[i],dp[i-j]+list_n[j])

print(dp[n])