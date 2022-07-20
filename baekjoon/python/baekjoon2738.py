import sys

input= sys.stdin.readline

n,m = map(int,input().split())
result =[[0]*m for _ in range(n)]

for i in range(2):
    for i in range(n):
        temp = list(map(int,input().split()))
        for j in range(m):
            result[i][j]+=temp[j]

for i in result:
    print(*i)
