import sys

input = sys.stdin.readline


dp = [[0 for _ in range(101)] for _ in range(101)]
n = int(input())
result = 0
for _ in range(n):
    x,y=map(int,input().split())
    for i in range(x,x+10):
        for j in range(y,y+10):
            dp[i][j]=1

for i in dp:
    result+=i.count(1)
print(result)