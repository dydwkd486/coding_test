import sys
from collections import deque
input = sys.stdin.readline
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
def bfs():
    q = deque()
    q.append([0, 0, 1])
    visit = [[[0] * 2 for i in range(m)] for i in range(n)]
    visit[0][0][1] = 1
    while q:
        a, b, w = q.popleft()
        if a == n - 1 and b == m - 1:
            return visit[a][b][w]
        for i in range(4):
            x = a + dx[i]
            y = b + dy[i]
            if 0 <= x < n and 0 <= y < m:
                if s[x][y] == 1 and w == 1:
                    visit[x][y][0] = visit[a][b][1] + 1
                    q.append([x, y, 0])
                elif s[x][y] == 0 and visit[x][y][w] == 0:
                    visit[x][y][w] = visit[a][b][w] + 1
                    q.append([x, y, w])
    return -1
n, m = map(int, input().split())
s = []
for i in range(n):
    s.append(list(map(int, list(input().strip()))))
print(bfs())
# import sys
# import copy
# from collections import deque
# sys.setrecursionlimit(100000)
# input= sys.stdin.readline

# dx =[1,0,-1,0]
# dy =[0,1,0,-1]

# n,m = map(int, input().split(" "))

# def bfs():
#     global count
#     queue=deque()
#     queue.append([0,0])
#     while queue:
        
#         temp=queue.popleft()
#         # print([n-1,m-1])
#         if temp==[n-1,m-1]:
#             return count
#         if clone_check[temp[0]][temp[1]]==False:
#             clone_check[temp[0]][temp[1]]=True
#             count=count+1
#             print(temp,count)
#             for i in range(4):
#                 temp_x=temp[0]+dx[i]
#                 temp_y=temp[1]+dy[i]
#                 if temp_x>=0 and temp_x<n and temp_y>=0 and temp_y<m:
#                     queue.append([temp_x,temp_y])
#     return 1000001
        





# array=[]
# check=[]
# count=0
# for i in range(n):
#     check_temp=[]
#     array.append(list(map(int, list(input().strip()))))
#     for j in range(m):
#         check_temp.append(False)
#     check.append(check_temp)

# for i in range(n):
#     for j in range(m):
#         if array[i][j]==1:
#             check[i][j]=True
# # clone_check=check
# for i in range(n):
#     for j in range(m):
#         clone_check=copy.deepcopy(check)
#         if clone_check[i][j]==True:
#             clone_check[i][j]=False
#             print(bfs())
#             count=0
