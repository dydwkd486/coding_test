from collections import deque
dx = [-1,1,0,0]
dy = [0,0,-1,1]
T = 10

for testCase in range(1,T+1):
    n = int(input())
    graph = [list(map(int,input())) for _ in range(16)]
    q = deque()
    result = 0
    for i in range(16):
        for j in range(16):
            if graph[i][j]==2:
                q.append((i,j))
            if graph[i][j]==2:
                end = (i,j)

    while q:
        x,y = q.popleft()
        for k in range(4):
            vx = dx[k]+x
            vy = dy[k]+y
            if -1<vx<16 and -1<vy<16:
                if graph[vx][vy] == 0:
                    graph[vx][vy]=1
                    q.append((vx,vy))
                elif graph[vx][vy] == 3:
                    result = 1
                    
    print(f"#{testCase} {result}")