# 최장 경로 11:03 -> 11:52 힌트봄
def dfs(x):
    global count
    global result
    if visited[x]==False:
        visited[x]=True
        count += 1
        for i in n_list[x]:
            dfs(i)
        result=max(count,result)
        visited[x] = False
        count -= 1

T = int(input())

for testCase in range(1,T+1):
    n,m = map(int,input().split())
    n_list=[[] for _ in range(n+1)]
    visited = [False for _ in range(n + 1)]
    result = 0
    for i in range(m):
        x,y = map(int,input().split())
        n_list[x].append(y)
        n_list[y].append(x)

    for i in range(1,n+1):
        count = 0
        dfs(i)
    print(f"#{testCase} {result}")


