import sys

n, m = map(int,sys.stdin.readline().split())
w=list(map(int,sys.stdin.readline().split()))
# print(w)
first=[1 for _ in range(n)]
# print(first)
for _ in range(m):
    x,y=map(int,sys.stdin.readline().split())
    if w[x-1]==w[y-1]:
        first[x-1]=0
        first[y-1]=0
    elif w[x-1]<w[y-1]:
        first[x-1]=0
    elif w[x-1]>w[y-1]:
        first[y-1]=0
print(sum(first))