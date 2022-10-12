#10시40분 -> 11시 50분 1시간 10분
from collections import deque
dx = [1,0,-1,0]
dy = [0,1,0,-1]

N,M = map(int,input().split())

graph = [list(map(int,input().split())) for _ in range(N)]

# 현재위치
curr_position =[0,0]
# 진행방향
direction = 0
# 전체 결과
result = 0
# 기본 주사위
cube = [5,4,1,3,2,6]

def move_cube():
    global curr_position,cube,direction
    y,x = curr_position
    # 현재 위치 변경하기
    vy= y+dy[direction%4]
    vx= x+dx[direction%4]
    if -1<vy<N and -1<vx<N:
        curr_position = [vy,vx]
    else: # 격자를 벗어나는 경우
        direction +=2
        vy = y+dy[direction%4]
        vx= x+dx[direction%4]
        curr_position = [vy,vx]

    if direction%4==0: # 오른쪽으로 이동
        temp = [cube[0],cube[5],cube[1],cube[2],cube[4],cube[3]]
    if direction%4==1: # 아래로 이동
        temp = [cube[5],cube[1],cube[0],cube[3],cube[2],cube[4]]
    if direction%4==2: # 왼쪽으로 이동
        temp = [cube[0],cube[2],cube[3],cube[5],cube[4],cube[1]]
    if direction%4==3: # 위로 이동
        temp = [cube[2],cube[1],cube[4],cube[3],cube[5],cube[0]]
    cube = temp

def score():
    global cube,graph,curr_position,result
    visited = [[False]*N for _ in range(N)]
    q = deque()
    q.append(curr_position)
    visited[curr_position[0]][curr_position[1]]= True
    color = graph[curr_position[0]][curr_position[1]]
    count=1
    while q:
        y,x = q.popleft()
        for i in range(4):
            vy = y+dy[i]
            vx = x+dx[i]
            if -1<vy<N and -1<vx<N:
                if visited[vy][vx] ==True: continue
                if color != graph[vy][vx]: continue
                visited[vy][vx]=True
                count+=1
                q.append([vy,vx])
    result += color*count
        
def rotate_cube():
    global cube,graph,curr_position,direction
    if cube[5] > graph[curr_position[0]][curr_position[1]]:
        direction+=1
    elif cube[5] < graph[curr_position[0]][curr_position[1]]:
        direction-=1
    

# M번 돌기
for tc in range(M):
    move_cube()
    score()
    rotate_cube()
print(result)
# 주사위 이동 시키기
# 점수 얻기
# 이동 후 진행방향 확인
