
from collections import deque
dx = [-1,1,0,0]
dy = [0,0,-1,1]
T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    graph = [list(map(int,input())) for _ in range(n)]
    visited=[[int(1e9)]*n for _ in range(n)]
    visited[0][0] = 0
    q = deque()
    q.append((0,0))
    while q:
        x,y = q.popleft()
        for k in range(4):
            vx = dx[k]+x
            vy = dy[k]+y
            if -1< vx < n and -1<vy<n:
                if visited[x][y] + graph[vx][vy]< visited[vx][vy]:
                    visited[vx][vy] = visited[x][y]+graph[vx][vy]
                    q.append((vx,vy))

    print(f"#{testCase} {visited[-1][-1]}")