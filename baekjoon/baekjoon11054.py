import sys

input= sys.stdin.readline

n= int(input())

n_list=list(map(int,input().split()))

# print(max_list)
result=[]
dp1=[1 for _ in range(n)]
dp2=[1 for _ in range(n)]

for i in range(n):
    for j in range(i):
        if n_list[i]>n_list[j]:
            dp1[i] = max(dp1[i],dp1[j]+1)
n_list.reverse()

for i in range(n):
    for j in range(i):
        if n_list[i]>n_list[j]:
            dp2[i] = max(dp2[i],dp2[j]+1)
dp2.reverse()

for i in range(n):
    result.append(dp1[i]+dp2[i])

print(max(result)-1)
