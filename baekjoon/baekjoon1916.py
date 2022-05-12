import sys
import heapq

INF = sys.maxsize
input = sys.stdin.readline

def solve():
    n = int(input())
    m = int(input())

    graph =[[] for _ in range(n+1)]
    value=[INF]*(n+1)
    for i in range(m):
        temp=list(map(int,input().split()))
        graph[temp[0]].append([temp[1],temp[2]])
        
    start,end=map(int,input().split())

    q=[]
    heapq.heappush(q,(0,start))
    value[start]=0

    while q:
        v= heapq.heappop(q)
        if value[v[1]]>=v[0]:
            for i in graph[v[1]]:
                cost = value[v[1]]+i[1]
                if cost < value[i[0]]:
                    value[i[0]]=cost
                    heapq.heappush(q,(cost,i[0]))

    print(value[end])
solve()