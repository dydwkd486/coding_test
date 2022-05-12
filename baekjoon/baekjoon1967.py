import sys
sys.setrecursionlimit(1000000)

input = sys.stdin.readline

def dfs(x,count):
    global total_count
    global totla_temp
    if total_count<count:
        total_count=count
        totla_temp = x
    if visited[x]==False:
        visited[x]=True
        for i in graph[x]:
            if visited[i[0]]==False:
                count+=i[1]
                dfs(i[0],count)
                count-=i[1]

n = int(input())
graph = [[] for _ in range(n+1)]
for _ in range(n):
    temp = list(map(int,input().split()))
    for i in range(1,len(temp)-2,2):
        graph[temp[0]].append([temp[i],temp[i+1]])
total_count=0
totla_temp=1
visited =[False for _ in range(n+1)]
dfs(1,0)

visited =[False for _ in range(n+1)]
total_count=0
dfs(totla_temp,0)

print(total_count)