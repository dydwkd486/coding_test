import sys
from collections import deque
dx = [0,0,1,-1]
dy = [1,-1,0,0]
input = sys.stdin.readline

n,l,r = list(map(int,input().split()))
graph = [list(map(int,input().split())) for _ in range(n)]
result =0
def bfs(sum,count,visited,queue):
    # y,x = queue
    visited_list = deque([queue[0]])
    while queue:
        y,x = queue.popleft()
        for i in range(4):
            vy = y+dy[i]
            vx = x+dx[i]
            if -1<vy<n and -1<vx<n and visited[vy][vx]==False:
                if l<=abs(graph[vy][vx]-graph[y][x])<=r:
                    visited[vy][vx]=True
                    sum += graph[vy][vx]
                    queue.append([vy,vx])
                    visited_list.append([vy,vx])
                    count+=1
    # print(sum)
    
    # 가능한 경우를 다 찾음
    # 이제 변경해야함.
    if count > 1:
        changed_value = sum//count
        for y,x in visited_list:
                    graph[y][x] = changed_value
        return True
    else:
        return False

# 입력 완료

# dfs 구현하기
# print(graph)

# 2000일을 돌수 있게 해야함.
# 초기화 
for _ in range(2000):
    visited = [[False]*n for _ in range(n)]
    total_bool = False
    for i in range(n):
        for j in range(n):
            if visited[i][j] == False:
                visited[i][j]=True
                queue = deque()
                queue.append([i,j])
                change_bool = bfs(graph[i][j],1,visited,queue)
                if change_bool:
                    total_bool =True
    if total_bool:
        result +=1
    else:
        break
            
print(result)
            

