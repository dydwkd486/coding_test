from sys import stdin
import sys
sys.setrecursionlimit(100000)
def dfs(i,j):
    if i<=-1 or j<=-1 or i>=N or j>=M:
        return False
    if graph[i][j]==1:
        graph[i][j] = 0
        dfs(i-1, j)
        dfs(i, j-1)
        dfs(i+1, j)
        dfs(i, j+1)
        return True
    return False

T = int(stdin.readline())
answer=[]
for _ in range(T):
    M,N,K= list(map(int,stdin.readline().split()))
    graph=[]
    count=0
    for i in range(N):
        temp=[]
        for j in range(M):
            temp.append(0)
        graph.append(temp)
    for i in range(K):
        y,x=list(map(int, stdin.readline().split()))
        graph[x][y]=1
    for i in range(N):
        # print("")
        for j in range(M):
            # print(graph[i][j],end="")
            if dfs(i,j)==True:
                count+=1
    answer.append(count)
for i in answer:
    print(i)
    # if dfs()==true:

