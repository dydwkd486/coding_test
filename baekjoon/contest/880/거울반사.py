import sys

key = {"L":0,"R":1,"U":2,"D":3}
input = sys.stdin.readline

W,N = input().split(" ")
N = int(N)
graph = [list(map(int,input().split())) for i in range(N)]
temp = [[0]*N for _ in range(N)] 
if key[W] ==0 or key[W]==1:
    for i in range(N):
        for j in range(N):
            temp[i][j] = graph[i][N-1-j]
            if temp[i][j]==8:
                temp[i][j]=8
            elif temp[i][j]==2:
                temp[i][j]=5
            elif temp[i][j]==5:
                temp[i][j]=2
            elif temp[i][j]==1:
                temp[i][j]=1
            else:
                temp[i][j]="?"
else:
    for i in range(N):
        for j in range(N):
            temp[j][i] = graph[N-1-j][i]
            if temp[j][i]==8:
                temp[j][i]=8
            elif temp[j][i]==2:
                temp[j][i]=5
            elif temp[j][i]==5:
                temp[j][i]=2
            elif temp[j][i]==1:
                temp[j][i]=1
            else:
                temp[j][i]="?"
for i in temp:
    print(*i)
print()
