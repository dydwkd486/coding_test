# 상호의 배틀 필드 05:48 -> 6:28 40분
T = int(input())
nx=[0,0,-1,1]
ny=[-1,1,0,0]

def shoot(s):
    dx = tank[0] + nx[s]
    dy = tank[1] + ny[s]
    while -1 < dx < h and -1 < dy < w:
        if graph[dx][dy] == "#":
            break
        elif graph[dx][dy] == "*":
            graph[dx][dy] = "."
            break
        dx += nx[s]
        dy += ny[s]

for testCase in range(1,T+1):
    h,w = map(int,input().split())
    graph = [list(input()) for i in range(h)]
    n = int(input())
    n_list = list(input())
    tank = []
    # 전차 위치 찾기
    for i in range(h):
        for j in range(w):
            if "<" in graph[i][j]:
                tank=[i,j]
            if ">" in graph[i][j]:
                tank=[i,j]
            if "^" in graph[i][j]:
                tank=[i,j]
            if "v" in graph[i][j]:
                tank=[i,j]
    # print(tank)
    for command in n_list:
        # 발사
        if command == "S":
            if "<" in graph[tank[0]][tank[1]]:
                shoot(0)
            elif ">" in graph[tank[0]][tank[1]]:
                shoot(1)
            elif "^" in graph[tank[0]][tank[1]]:
                shoot(2)
            elif "v" in graph[tank[0]][tank[1]]:
                shoot(3)
        elif command == "U":
            graph[tank[0]][tank[1]]="^"
            dx = tank[0] + nx[2]
            dy = tank[1] + ny[2]
            if -1 < dx < h and -1 < dy < w and graph[dx][dy]==".":
                graph[tank[0]][tank[1]] = "."
                graph[dx][dy] = "^"
                tank =[dx,dy]
        elif command == "R":
            graph[tank[0]][tank[1]]=">"
            dx = tank[0] + nx[1]
            dy = tank[1] + ny[1]
            if -1 < dx < h and -1 < dy < w and graph[dx][dy]==".":
                graph[tank[0]][tank[1]] = "."
                graph[dx][dy] = ">"
                tank =[dx,dy]
        elif command == "D":
            graph[tank[0]][tank[1]]="v"
            dx = tank[0] + nx[3]
            dy = tank[1] + ny[3]
            if -1 < dx < h and -1 < dy < w and graph[dx][dy]==".":
                graph[tank[0]][tank[1]] = "."
                graph[dx][dy] = "v"
                tank =[dx,dy]
        elif command == "L":
            graph[tank[0]][tank[1]]="<"
            dx = tank[0] + nx[0]
            dy = tank[1] + ny[0]
            if -1 < dx < h and -1 < dy < w and graph[dx][dy]==".":
                graph[tank[0]][tank[1]] = "."
                graph[dx][dy] = "<"
                tank =[dx,dy]
        # print(command)
    print(f"#{testCase}",end=" ")
    for i in graph:
        print(''.join(i))

            
