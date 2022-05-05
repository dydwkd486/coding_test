import sys

input= sys.stdin.readline

n= int(input())
n_list=list(map(int,input().split()))

result=[]
dp=[1 for _ in range(n)]

n_list.reverse()

for i in range(n):
    for j in range(i):
        if n_list[i]>n_list[j]:
            dp[i] = max(dp[i],dp[j]+1)
dp.reverse()

print(max(dp))
