import sys

input = sys.stdin.readline

n= int(input())

list_n=[]
for i in range(n):
    list_n.append(int(input()))

dp=[list_n[0]]
if len(list_n)==1:
    dp=[list_n[0]]
elif len(list_n)==2:
    dp.append(list_n[0]+list_n[1])
else:
    dp.append(list_n[0]+list_n[1])
    dp.append(max(list_n[0]+list_n[2],list_n[1]+list_n[2]))

    for i in range(3,n):
        dp.append(max(dp[i-3]+list_n[i-1]+list_n[i],dp[i-2]+list_n[i]))

print(dp[-1])