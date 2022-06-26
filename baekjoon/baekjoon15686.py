import sys
from itertools import combinations
input = sys.stdin.readline

n,m= map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(n)]
chicken = []
home = []
result = 1e9
for i in range(len(graph)):
    for j in range(len(graph[i])):
        if graph[i][j]==2:
            chicken.append([i,j])
        elif graph[i][j]==1:
            home.append([i,j])

chicken_com = list(combinations(chicken,m))
for i in chicken_com:
    temp=[1e9]*len(home)
    for j in range(len(home)):
        for k in i:
            temp[j] = min(temp[j],abs(k[0]-home[j][0])+abs(k[1]-home[j][1]))
    result = min(result,sum(temp))
print(result)
        