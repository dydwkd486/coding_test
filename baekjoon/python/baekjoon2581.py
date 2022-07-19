import sys

input = sys.stdin.readline

start=int(input())
end=int(input())
n_list=[False,False]+[True]*(end-1)
temp=[]

for i in range(2,end+1):
    if n_list[i]:
        temp.append(i)
        for j in range(2*i,end+1,i):
            n_list[j]=False
result=[]
for i in temp:
    if start<=i:
        result.append(i)
if len(result)==0:
    print(-1)
else:
    print(sum(result))
    print(result[0])
