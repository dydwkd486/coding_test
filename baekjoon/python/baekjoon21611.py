# 좌하우상
dy = [0,1,0,-1]
dx = [-1,0,1,0]
move=[]
move_graph =[]
marble=[0,0,0,0]

def ice(n_list):
    global graph
    temp = [[0]*N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            temp[i][j] = graph[i][j]
    ice_dy = [-1,1,0,0]
    ice_dx = [0,0,-1,1]
    pos = n_list[0]-1 # 0이 기준이라 한개 줄여야한다.
    size = n_list[1]
    vy=N//2
    vx=N//2
    for i in range(size):
        vy+=ice_dy[pos]
        vx+=ice_dx[pos]
        temp[vy][vx] = 0
    graph=temp

def move_marble():
    global move_graph,graph
    temp = [[0] * N for _ in range(N)]
    start=0
    for ind,(y,x) in enumerate(move_graph):
        if graph[y][x] != 0:
            vy,vx = move_graph[start]
            temp[vy][vx] = graph[y][x]
            start+=1
    graph = temp

def bomb():
    global move_graph,graph,marble
    start=1
    color=0
    flag=False
    for idx,(y,x) in enumerate(move_graph):
        if graph[y][x] == color: # 색이 같다면?
            start+=1
        else: # 색이 다르면
            if start>=4: # 4이상이면 폭팔
                for i in range(start):
                    vy,vx= move_graph[idx-1-i]
                    marble[graph[vy][vx]]+=1
                    graph[vy][vx] = 0
                    flag=True
            # 초기화
            color = graph[y][x]
            start =1
    return flag

def marble_change():
    global move_graph, graph
    temp = [[0] * N for _ in range(N)]
    start=0 # temp 에 적용할 용도
    count=1
    color=0
    for idx,(y,x) in enumerate(move_graph):
        if idx==0: # 처음에 초기화
            color=graph[y][x]
            count=1
        elif graph[y][x] == color:
            count += 1
        else: # 색이 다른 경우
            vy,vx = move_graph[start]
            temp[vy][vx]=count
            start+=1
            vy,vx = move_graph[start]
            temp[vy][vx]=color
            start+=1
            if start>=len(move_graph): # 초과하는 경우 멈춰!
                break
            # 초기화
            color=graph[y][x]
            count=1
    graph = temp
            
            

N,M = map(int,input().split())

for i in range(N-1):
    move.append(i+1)
    move.append(i+1)
move.append(N-1)

start_y = N//2
start_x = N//2
for i in range(len(move)):
    for j in range(move[i]):
        start_y+=dy[i%4]
        start_x+=dx[i%4]
        move_graph.append([start_y,start_x])
print(move_graph)
graph=[list(map(int,input().split())) for _ in range(N)]
n_list =  [list(map(int,input().split())) for _ in range(M)]

# 상어가 먼저 마법을 사용해야함.
for tc in range(M):
    ice(n_list[tc])

    # 터질게 없을때까지 반복
    while True:
        # 구슬이 움직이게 구현
        move_marble()
        # 4개이상 같은 구슬이 있으면 파괴
        flag = bomb()
        if not flag:
            break
    # 구슬 변화
    marble_change()
    # for i in graph:
    #     print(i)
    # print()

# print(marble)
result =0
for i,x in enumerate(marble):
    result+=i*x
print(result)