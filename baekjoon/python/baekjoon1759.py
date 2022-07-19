import sys

input = sys.stdin.readline

l,c = map(int,input().split())

n = list(input().split())
visited=[0 for _ in range(c)]
result=[]
n.sort()
def dfs(x,count):
    if l == x:
        vo = 0
        co = 0
        for i in range(l):
            if result[i] in 'aeiou': vo += 1
            else: co += 1
        if vo >= 1 and co >= 2:
            print(''.join(result))

    for i in range(count, c):
        if visited[i] == 0:
            result.append(n[i])
            visited[i] = 1
            dfs(x + 1, i + 1)
            visited[i] = 0
            del result[-1]

dfs(0,0)