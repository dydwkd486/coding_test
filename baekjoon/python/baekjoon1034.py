import sys

input = sys.stdin.readline

n,m = map(int,input().split())
graph = [list(map(int,input().strip())) for _ in range(n)]
k = int(input())
result = 0
for i in graph: 
    temp = i.count(0) 
    if temp <= k and temp%2 == k%2: 
        cnt = 0
        for j in graph : 
            if j == i: 
                cnt += 1
        if cnt > result : 
            result = cnt
print(result)