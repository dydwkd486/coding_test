import sys
input = sys.stdin.readline

n = int(input())

n_list=tuple(map(int,input().split()))
start=1
max_len=1
temp=[1,1]

while start<=n-1:
    if n_list[start-1]<=n_list[start]:
        temp[0]+=1
    else:
        temp[0]=1
    if n_list[start-1]>=n_list[start]:
        temp[1]+=1
    else:
        temp[1]=1
    max_len=max(max_len,temp[0],temp[1])
    start+=1
print(max_len)
