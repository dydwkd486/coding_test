import sys
input = sys.stdin.readline

n,m = list(map(int,input().split()))

graph = []
stack = [[0]*(m+1) for _ in range(n+1)]
for i in range(n):
    graph.append(list(map(int,input().split())))

for i in range(1,n+1):
    for j in range(1,m+1):
        stack[i][j] = graph[i-1][j-1]+ max(stack[i-1][j],stack[i][j-1],stack[i-1][j-1])
print(stack[-1][-1])
