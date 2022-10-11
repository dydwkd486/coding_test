from collections import deque
dx = [0,0,1,-1]
dy =[1,-1,0,0]
N,M = map(int,input().split())
graph = [list(map(int,input().split())) for _ in range(N)]


def bfs(i,j):
    global graph,visited,n_list
    temp_visited =[[False]*N for _ in range(N)] # 이녀석 따로 쓸 용
    q = deque()
    q.append([i,j])
    visited[i][j]=True
    temp_visited[i][j]=True
    count = 0
    red_count=0
    standard = (-1,-1)
    while q:
        y,x = q.popleft()
        for k in range(4):
            vy= y+dy[k]  
            vx= x+dx[k]
            if(-1<vy<N and -1<vx<N):
                if visited[vy][vx]==True: continue # 방문했으면 갈 필요 없음.
                if visited[vy][vx]<-1: continue # 검은 돌,빈공간이면 할 필요 없음.
                if graph[i][j] == graph[vy][vx] or graph[vy][vx]==0: # 같은 색
                    visited[vy][vx]=True
                    temp_visited[vy][vx]=True
                    q.append([vy,vx])
    for y in range(N):
        for x in range(N):
            if not temp_visited[y][x]:
                continue
            count+=1
            if graph[y][x] ==0:
                red_count+=1
            elif (y,-x)>standard:
                standard = (y,-x)

    if count>=2:
        temp=[i,j,count,red_count,standard[0],-standard[1]]
        n_list.append(temp)
    # 레드 폭탄은 원상복귀
    for i in range(N):
        for j in range(N):
            if graph[i][j]==0:
                visited[i][j]=False
    # print("전체 계산:",count,red_count,row_count,col_count)

def gravity():
    global graph
    temp =[ [-2]*N for _ in range(N)]
    for i in range(N):
        start=N-1
        for j in range(N-1,-1,-1):
            if graph[j][i]== -2: continue
            if graph[j][i]== -1:
                temp[j][i] = -1
                start = j-1
                continue
            temp[start][i]=graph[j][i]
            start-=1

    graph = temp

def rotate():
    global graph
    temp =[ [0]*N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            temp[i][j] = graph[j][N-1-i]
    # for i in temp:
    #     print(i)
    graph = temp


result =0
while True:
    visited =[ [False]*N for _ in range(N)]
    n_list = []
    # 전체 확인
    for i in range(N):
        for j in range(N):
            if graph[i][j]<0: continue
            if visited[i][j]==True: continue
            bfs(i,j)

    # 여기서 폭탄이 많은 경우
    bomb = -1
    for i in n_list:
        # 최대 값 찾기
        bomb = max(bomb,i[2])
    bomb_temp = []
    for i in n_list:
        if bomb==i[2]:
            bomb_temp.append(i)
    if len(bomb_temp)>1: # 조건 1
        bomb = 30
        bomb_temp1=[]
        for i in bomb_temp:
            # 레드 개수 적은 값 찾기
            bomb = min(bomb,i[3])
        for i in bomb_temp:
            if bomb==i[3]:
                bomb_temp1.append(i)
        bomb_temp = bomb_temp1
    if len(bomb_temp)>1: # 조건 2
        bomb = -1
        bomb_temp1=[]
        for i in bomb_temp:
            # 행 개수 많은 값 찾기
            bomb = max(bomb,i[4])
        for i in bomb_temp:
            if bomb==i[4]:
                bomb_temp1.append(i)
        bomb_temp= bomb_temp1
    if len(bomb_temp)>1: # 조건 3
        bomb = 30
        bomb_temp1=[]
        for i in bomb_temp:
            # 기준점에서 열 개수 적은 값 찾기
            bomb = min(bomb,i[5])
        for i in bomb_temp:
            if bomb==i[5]:
                bomb_temp1.append(i)
        bomb_temp = bomb_temp1
    # print("bomb",bomb_temp[0])
    # print(len(bomb_temp))
    # print(bomb_temp)
    if len(bomb_temp)==0:
        break
    result+=bomb_temp[0][2]**2
    # 파괴할 폭탄 찾음

    # 폭탄 제거
    q = deque()
    i = bomb_temp[0][0]
    j = bomb_temp[0][1]
    q.append([i,j])
    color = graph[i][j]
    graph[i][j]=-2
    while q:
        y,x = q.popleft()
        for k in range(4):
            vy= y+dy[k]  
            vx= x+dx[k]
            if(-1<vy<N and -1<vx<N):
                if graph[vy][vx]==color or graph[vy][vx]==0:
                    graph[vy][vx]=-2
                    q.append([vy,vx])

    # print(n_list)
    # 중력으로 내리기
    gravity()
    rotate()
    gravity()

    # restart = False
    # for i in range(N):
    #     for j in range(N):
    #         if graph[i][j]>-1:
    #             restart=True
    # if not restart:
    #     break
                

print(result)