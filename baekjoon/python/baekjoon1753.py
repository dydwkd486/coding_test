import sys
import heapq
input = sys.stdin.readline

V,E = map(int,input().split())
start = int(input())

INF = int(1e9)
graph=[[] for _ in range(V+1)]
graph_distance=[INF for _ in range(V+1)]

# print(graph_distance)

for i in range(E):
    u,v,w = map(int,input().split())
    graph[u].append((v,w))

q = []
heapq.heappush(q,(0,start))
graph_distance[start]=0

while q:
    v= heapq.heappop(q)
    if graph_distance[v[1]]>=v[0]:
        for i in graph[v[1]]:
            cost = graph_distance[v[1]]+i[1]
            if cost<graph_distance[i[0]]:
                graph_distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))

for i in graph_distance[1:]:
    if i==INF:
        print("INF")
    else:
        print(i)