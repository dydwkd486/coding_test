import sys
from collections import deque
import copy

def dfs(x,y,graph):
    if x<=-1 or x>=n or y<=-1 or y>=m:
        return False
    if graph[x][y]==0:
        graph[x][y]=2
        dfs(x-1,y,graph)
        dfs(x,y-1,graph)
        dfs(x+1,y,graph)
        dfs(x,y+1,graph)
        return True
    return False
    
'''
2 4
0 0 0 0
2 0 0 0
'''
dx=[0,0,1,-1]
dy=[1,-1,0,0]
n, m = map(int,sys.stdin.readline().split())

result_max=0
# print(n,m)
graph=[]
for i in range(n):
    graph.append(list(map(int,sys.stdin.readline().split(" "))))
# print(graph)

for i in range(0,n*m-2):
    if graph[i//m][i%m]==0:
        for j in range(i+1,n*m-1):
            if graph[j//m][j%m]==0:
                for z in range(j+1,n*m):
                    if graph[z//m][z%m]==0:
                        graph_temp=copy.deepcopy(graph)
                        graph_temp[i//m][i%m]=1
                        graph_temp[j//m][j%m]=1
                        graph_temp[z//m][z%m]=1
                        # print(graph_temp)
                        for l in range(n):
                            for c in range(m):
                                # print(graph_temp[l][c])
                                if graph_temp[l][c]==2:
                                    dfs(l-1,c,graph_temp)
                                    dfs(l,c-1,graph_temp)
                                    dfs(l+1,c,graph_temp)
                                    dfs(l,c+1,graph_temp)
                                    # print(graph_temp)
                        result=0
                        for aa in graph_temp:
                            result+=aa.count(0)
                        if result_max<result:
                            result_max=result
print(result_max)