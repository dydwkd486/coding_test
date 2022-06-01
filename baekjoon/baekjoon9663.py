# pypy3로 통과
import sys

input= sys.stdin.readline

n = int(input())

queens = [0 for _ in range(n)]
result = [0]
visited = [False for _ in range(n)]

def check(idx):
    for i in range(idx):
        if queens[idx] == queens[i] or abs(queens[idx] - queens[i]) == idx-i:
            return False
    return True

def dfs(idx):
    if idx == n:
        result[0]+=1
        return
    for i in range(n):
        if visited[i]:
            continue
        queens[idx] = i
        if check(idx):
            visited[i]=True
            dfs(idx+1)
            visited[i]=False

dfs(0)
print(result[0])