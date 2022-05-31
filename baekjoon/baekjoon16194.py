import sys
input = sys.stdin.readline

n=int(input())

list_n=[0]+list(map(int,input().split()))
dp=list_n[::]


for i in range(1,n+1):
    for j in range(1,i+1):
        dp[i] = min(dp[i],dp[i-j]+list_n[j])
    # print(dp)
    # print("")

print(dp[n])