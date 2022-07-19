import sys
import heapq
INF = 1e9
input = sys.stdin.readline

n,m,x = map(int,input().split())

graph = [[] for _ in range(n+1)]

for i in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))
result=[]
for j in range(1,n+1):
    q =[]
    graph_distance = [INF for _ in range(n+1)]
    heapq.heappush(q,(0,j))
    graph_distance[j]=0
    while q:
        v= heapq.heappop(q)
        if graph_distance[v[1]]>=v[0]:
            for i in graph[v[1]]:
                cost = graph_distance[v[1]]+i[1]
                if cost < graph_distance[i[0]]:
                    graph_distance[i[0]]=cost
                    heapq.heappush(q,(cost,i[0]))
    if j == x:
        return_x=graph_distance[1:]
        result.append(0)
        # print(graph_distance[1:])
    else:
        result.append(graph_distance[1:][x-1])

# print(result)
answer=[]
for i in range(n):
    answer.append(result[i]+return_x[i])
print(max(answer))


