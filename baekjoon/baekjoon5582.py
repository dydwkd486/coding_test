import sys

input = sys.stdin.readline

a = list(input().strip())
b = list(input().strip())
dp =[[0]*(len(a)+1) for i in range(len(b)+1)]
result =0
for i in range(1,len(b)+1):
    for j in range(1,len(a)+1):
        if a[j-1]==b[i-1]:
            dp[i][j]=dp[i-1][j-1]+1
            result=max(dp[i][j],result)
print(result)

