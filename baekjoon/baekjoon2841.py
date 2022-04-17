import sys

input = sys.stdin.readline

n,p= map(int,input().split())
n_list = [[0] for _ in range(7)]
count=0
for i in range(n):
    x,y= map(int,input().split())
    while n_list[x][-1]>y:
        count+=1
        del n_list[x][-1]
    if n_list[x][-1]<y:
        count+=1
        n_list[x].append(y)
print(count)