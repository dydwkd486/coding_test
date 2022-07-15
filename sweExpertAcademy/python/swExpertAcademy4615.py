# 재미있는 오셀로 게임 02:46->
nx =[0,0,1,-1,1,1,-1,-1]
ny =[1,-1,0,0,1,-1,1,-1]
T = int(input())

for testCase in range(1,T+1):
    n,m = map(int,input().split())
    graph= [[0 for _ in range(n+1)] for _ in range(n+1)]
    graph[n // 2][n // 2] = graph[n // 2+1][n // 2+1] = 2
    graph[n // 2+1][n // 2] = graph[n // 2][n // 2+1] = 1

    a=0
    b=0
    for _ in range(m):
        x,y,z = map(int,input().split())
        graph[x][y]=z
        for i in range(8):
            vx = x+nx[i]
            vy = y+ny[i]
            target= []
            while -1<vx<n+1 and -1<vy<n+1:
                if graph[vx][vy]==3-z:
                    target.append((vx, vy))
                else:
                    if graph[vx][vy]==z:
                        for tx,ty in target:
                            graph[tx][ty]=z
                    break
                vx += nx[i]
                vy += ny[i]
    # print("")
    # for i in graph:
    #     print(i)
    for i in graph:
        a+=i.count(1)
        b+=i.count(2)

    print(f"#{testCase} {a} {b}")