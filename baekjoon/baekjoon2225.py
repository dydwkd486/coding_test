import sys

input = sys.stdin.readline

dp = [[i for i in range(1,202)]]

for i in range(200):
    temp=[1]
    for i in range(0,200):
        temp.append((temp[i]+dp[-1][i+1])%1000000000)
    dp.append(temp)

n = list(map(int,input().split()))
print(dp[n[0]-1][n[1]-1])