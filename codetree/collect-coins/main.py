# 소요시간 50분
# 1~9의 숫자로 되어있음.
# 천천히 커지는 순서대로 수집 가능
# 해당 위치를 지나가더라도 동전을 수집하지 않아도 됨
# 같은 위치 2번 이상 지나가는것 허용

# 정렬후 조합을 통해 갈 수 있는 모든 경우의수를 뽑음
# 최소 3번
from collections import deque,defaultdict
from itertools import combinations
dx=[0,0,1,-1]
dy=[1,-1,0,0]

def start_to_end(curr,next):
    global graph
    temp = [[0]*N for _ in range(N)]
    q = deque()
    q.append(curr)
    temp[curr[0]][curr[1]] = 1 # 시작이 1 이기 때문에 나중에 1빼기 해주기
    while q:
        y,x = q.popleft()
        for i in range(4):
            vy,vx = y+dy[i],x+dx[i]
            if(-1<vy<N and -1<vx<N):
                if temp[vy][vx]!=0: continue
                if graph[vy][vx]=="#": continue
                temp[vy][vx] = temp[y][x]+1
                q.append([vy,vx])
    if temp[next[0]][next[1]]==0: # 들리지 못함
        return False
    return True
    
    
def bfs(next):
    global graph,start,end,curr,count
    # 시작 위치
    # 도착 위치까지의 거리 계산 저장
    temp = [[0]*N for _ in range(N)]
    q = deque()
    q.append(curr)
    temp[curr[0]][curr[1]] = 1 # 시작이 1 이기 때문에 나중에 1빼기 해주기
    while q:
        y,x = q.popleft()
        for i in range(4):
            vy,vx = y+dy[i],x+dx[i]
            if(-1<vy<N and -1<vx<N):
                if temp[vy][vx]!=0: continue
                if graph[vy][vx]=="#": continue
                temp[vy][vx] = temp[y][x]+1
                q.append([vy,vx])
    count+=temp[next[0]][next[1]]-1
    curr = next
    return

N = int(input())
graph = [list(input().strip()) for _ in range(N)]
start=[]
end=[]
curr =[]
n_dict=defaultdict(int)
n_num=[]
count=0
result=2e9
for i in range(N):
    for j in range(N):
        if graph[i][j]=="S":
            start=[i,j]
        elif graph[i][j]=="E":
            end=[i,j]
        elif graph[i][j]!="." and graph[i][j]!="#":
            n_dict[int(graph[i][j])]=[i,j]
            n_num.append(int(graph[i][j]))

n_num.sort()

# 정렬로 모든 경우의수 뽑기
combs = combinations(n_num,3)
for comb in combs:
    curr = start
    count=0
    flag = True
    for i in comb:
        # 현재위치에서 원하는 위치 까지 가는것이 가능한지 확인하기
        if not start_to_end(curr,n_dict[i]):
            flag=False
            break
        # 가능 하다면 이동하기
        bfs(n_dict[i])
    # 마지막 도착지점
    # 현재위치에서 원하는 위치 까지 가는것이 가능한지 확인하기
    if not start_to_end(curr,end):
        flag=False
    else:
        # 가능 하다면 이동하기
        bfs(end)
    if flag:
        result= min(result,count)
# 그 경우의 수로 반복문 생성
# 반복문 맨 처음에는 시작 위치로 변경
# 총 3번 BFS 반복
# 반복후 최소값으로 결과 변경
if result == 2e9:
    print(-1)
else:
    print(result)
# 종료

