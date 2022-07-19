import sys

input = sys.stdin.readline

graph = [list(map(int,input().split())) for _ in range(9)]
n_list = []
for y in range(9):
    for x in range(9):
        if graph[y][x]==0:
            n_list.append([y,x])
# print(n_list)

def check(x,y,a):
    for i in range(9):
        if graph[y][i]==a:
            return False
        if graph[i][x]==a:
            return False
    nx = x//3*3
    ny = y//3*3
    for i in range(3):
        for j in range(3):
            if a == graph[ny+i][nx+j]:
                return False
    return True
    
def dfs(idx):
    if idx == len(n_list):
        for i in range(9):
            print(*graph[i])
        # return
        exit(0)
    for i in range(1,10):
        y,x = n_list[idx]
        # check 할 필요있음.
        if check(x,y,i):
            graph[y][x]=i
            dfs(idx+1)
            graph[y][x]=0
dfs(0)