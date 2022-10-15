# 16시~ 16시44분 40분 컷
# 특수 영양제 이동 0
# 특수 영양제 투입 0
# 투입한 위치에 1 증가 0
# 대각선만 리브로수 높이가 1이상인 개수 만큼 추가 증가 0
# 영양제를 주지 않은 리브로수의 높이가 2이상인 리브로수-2를 해줌
    # 자린 리브로수로 특수 영양제를 삼
    # 여기서 자른 리브로수 위에 특수 영양제를 올림
dy=[0,0,-1,-1,-1,0,1,1,1] # 1  2 3 4  5 6 7 8
dx=[0,1,1,0,-1,-1,-1,0,1] # → ↗ ↑ ↖ ← ↙ ↓ ↘

N,M = map(int,input().split())

graph =[list(map(int,input().split())) for _ in range(N)]
ac_graph =[[0]*N for _ in range(N)] # 영양제 그래프

n_list = [list(map(int,input().split())) for _ in range(M)]

# 영양제 그래프 초기화
ac_graph[N-1][0]=1
ac_graph[N-1][1]=1
ac_graph[N-2][0]=1
ac_graph[N-2][1]=1

def ac_move(d,p):
    global ac_graph
    temp=[[0]*N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if ac_graph[i][j]==1:
                temp[(i+dy[d]*p)%N][(j+dx[d]*p)%N] = 1
    ac_graph = temp

def ac_first():
    global graph,ac_graph
    temp=[graph[i][:] for i in range(N)]
    
    for i in range(N):
        for j in range(N):
            if ac_graph[i][j]==1: # 한칸 증가 시키기
                temp[i][j]+=1
    graph = temp

def ac_second():
    global graph,ac_graph
    temp=[graph[i][:] for i in range(N)]
    for i in range(N):
        for j in range(N):
            if ac_graph[i][j]==1: # 대각선 개수 만큼 증가 시키기
                count =0
                for k in range(2,9,2):
                    vy = i + dy[k]
                    vx = j + dx[k]
                    if(-1<vy<N and -1<vx<N):
                        if graph[vy][vx] > 0: # 1 이상인 나무들
                            count+=1
                temp[i][j]+=count
    graph=temp

def tree_cut():
    global graph,ac_graph
    temp=[graph[i][:] for i in range(N)]
    ac_temp = [[0]*N for _ in range(N)]
    for i in range(N):
        for j in range(N):
            if ac_graph[i][j]==0 and graph[i][j]>=2: # 영양제 넣은 곳은 제외, 나무가 2 이상인 것
                temp[i][j] -=2
                ac_temp[i][j]=1
    graph= temp
    ac_graph = ac_temp

def ac_insert():
    ac_first()
    ac_second()
    

for i in range(M):
    D,P = n_list[i]
    ac_move(D,P)
    ac_insert()
    tree_cut()
result =0
for i in graph:
    result+=sum(i)
print(result)
    