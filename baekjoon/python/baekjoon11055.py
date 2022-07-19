# dp 문제
import sys

input =sys.stdin.readline

n = int(input())
a=list(map(int,input().split()))

dp =[0 for i in range(n)]
dp[0]=a[0]

for i in range(1,n):
    temp=[]
    # print(a[:i],a[i])
    for j in range(len(a[:i])):
        if a[j]<a[i]:
            temp.append(dp[j])
    if not temp:
        dp[i]=a[i]
    else:
        dp[i]=max(temp)+a[i]
print(max(dp))
