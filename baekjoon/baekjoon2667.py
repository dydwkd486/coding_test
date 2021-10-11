import sys

dx=[0,0,1,-1]
dy=[1,-1,0,0]

def dfs(n,m):
    if n<0 or n>=maximam or m<0 or m>=maximam:
        return 0
    if graph[n][m]==1:
        graph[n][m]=0
        global count
        count+=1
        for i in range(4):
            nx=n+dx[i]
            nm=m+dy[i]
            dfs(nx,nm)
        return 1
    return 0

result=[]
n = int(sys.stdin.readline())
count=0
maximam=n
graph=[]
for i in range(n):
    graph.append(list(map(int, input())))

# print(graph)

for i in range(n):
    cnt=0
    while cnt<n:
        if dfs(i,cnt)==1:
            result.append(count)
            count=0
        cnt+=1

# print(result)
result.sort()
print(len(result))
for i in range(len(result)):
    print(result[i])


            
