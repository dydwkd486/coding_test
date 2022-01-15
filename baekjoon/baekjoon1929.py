import sys

input = sys.stdin.readline

start, end = list(map(int,input().split()))

n_list = [False,False]+[True]*(end-1)
result=[]
for i in range(2,end+1):
    if n_list[i]:
        result.append(i)
        for j in range(2*i,end+1,i):
            n_list[j]=False
for i in result:
    if start<=i:
        print(i)