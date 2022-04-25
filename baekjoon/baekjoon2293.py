import sys
input= sys.stdin.readline


n,k = map(int,input().split())
n_list= []
dp = [0 for _ in range(k+1)]
dp[0]=1
for i in range(n):
    n_list.append(int(input()))

for i in n_list:
    for j in range(1,k+1):
        if j-i >= 0:
            dp[j]+=dp[j-i]
print(dp[k])