import sys

input = sys.stdin.readline

n,m,p = map(int,input().split())
n_bool = [False]*(m+1)
count = 0
n_dict = dict()
cur = p
for i in range(1,m+1):
    n_dict[i] = 0
for i in range(n):
    a,b = map(int,input().split())
    if n_dict[b]==0:
        n_dict[b]=a
while True:
    if n_dict[cur]==0:
        break
    else:
        if n_bool[n_dict[cur]]==True:
            count=-1
            break
        else:
            n_bool[n_dict[cur]]=True
            cur = n_dict[cur]
            count+=1
print(count)
