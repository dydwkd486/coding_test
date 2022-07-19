import sys
from collections import deque
# 다시 한번 생각하며 풀어보기 BFS의 문제중에 BFS 문제로 푸는 문제인 느낌..
# 재귀함수 제한 풀기
sys.setrecursionlimit(15000)

dx=[0,0,0,0,1,-1]
dy=[0,0,1,-1,0,0]
dz=[1,-1,0,0,0,0]

def bfs():
    while q:
        x1, y1, z1 = q.popleft()
        check[z1][y1][x1] = 1
        for i in range(6):
            x = x1 + dx[i]
            y = y1 + dy[i]
            z = z1 + dz[i]
            if 0 <= y < b and 0 <= x < a and 0 <= z < c and test[z][y][x] == 0 and check[z][y][x] == 0:
                q.append([x, y, z])
                test[z][y][x] = test[z1][y1][x1] + 1
                check[z][y][x] = 1
    

check=[]
test=[]
q = deque()
isTrue = False
a,b,c = map(int,sys.stdin.readline().split(" "))

for i in range(c):
    tmep_y=[]
    for j in range(b):
        tmep_x=[]
        for k in range(a):
            tmep_x.append(0)
        tmep_y.append(tmep_x)
    check.append(tmep_y)

for i in range(c):
    tmep_y=[]
    for j in range(b):
        tmep_y.append(list(map(int,sys.stdin.readline().split(" "))))
    test.append(tmep_y)


for z in range(c):
    for y in range(b):
        for x in range(a):
            if test[z][y][x] == 1:
                q.append([x, y, z])

bfs()

max_num = 0
for z in range(c):
    for y in range(b):
        for x in range(a):
            if test[z][y][x] == 0:
                isTrue = True
            max_num = max(max_num, test[z][y][x])
if isTrue == True:
    print(-1)
else:
    print(max_num - 1)