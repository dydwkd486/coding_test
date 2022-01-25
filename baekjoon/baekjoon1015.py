import sys

input=sys.stdin.readline

n = int(input())

a = list(map(int,input().split()))
s_li = sorted(a)
li = []

for i in range(n):
    idx = s_li.index(a[i])
    li.append(idx)
    s_li[idx]=-1

print(*li)