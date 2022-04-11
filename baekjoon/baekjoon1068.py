import sys
from collections import deque
input = sys.stdin.readline
def dfs(num, graph):
    graph[num]=-2
    for i in range(len(graph)):
        if num==graph[i]:
            dfs(i,graph)

n=int(input())
# graph=[[] for _ in range(n)]
n_list=list(map(int,input().split()))
n_remove = int(input())
dfs(n_remove,n_list)
count=0

for i in range(len(n_list)):
    if n_list[i]!=-2 and i not in n_list: # 리프 노드만을 확인 
        count+=1
                
print(count)