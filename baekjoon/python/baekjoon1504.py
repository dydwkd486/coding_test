import sys
import heapq

INF = 1e9
input= sys.stdin.readline

n,e= map(int,input().split())

graph=[[] for _ in range(n+1)]

for i in range(e):
    x,y,z = map(int,input().split())
    graph[x].append((y,z))
    graph[y].append((x,z))

v1,v2= map(int,input().split())

start_list=[1,v1,v2]
result=[]
for start in start_list:
    q =[]
    graph_distance=[INF for _ in range(n+1)]
    heapq.heappush(q,(0,start))
    graph_distance[start]= 0

    while q:
        v= heapq.heappop(q)
        if graph_distance[v[1]]< v[0]:
            continue
        for i in graph[v[1]]:
            cost = graph_distance[v[1]]+i[1]
            if cost<graph_distance[i[0]]:
                graph_distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))
    result.append(graph_distance)

answer = min(result[0][v1]+result[1][v2]+result[2][n],
            result[0][v2]+result[2][v1]+result[1][n])
if answer >= INF:
    print(-1)
else:
    print(answer)
