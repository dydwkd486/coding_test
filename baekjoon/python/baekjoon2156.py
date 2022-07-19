import sys

input = sys.stdin.readline

n=int(input())
dp=[0]
list_n=[]
for i in range(n):
    list_n.append(int(input()))

dp.append(list_n[0])

# 한잔인 경우
if len(list_n)>1:
    dp.append(list_n[0]+list_n[1])

for i in range(n-2):
    dp.append(max(dp[-1],(dp[i+1]+list_n[i+2]),(dp[i]+list_n[i+1]+list_n[i+2])))

print(max(dp))