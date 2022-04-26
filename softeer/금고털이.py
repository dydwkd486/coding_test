import sys

input= sys.stdin.readline

w, n = map(int,input().split())

dp = {}
result=0
for i in range(n):
    m,p = map(int,input().split())
    if p in dp:
        dp[p]+=m
    else:
        dp[p]=m

for i in range(100001,-1,-1):
    if i in dp:
        if w>dp[i]:
            result=result+dp[i]*i
            w=w-dp[i]
        else:
            result=result+w*i
            break
print(result)