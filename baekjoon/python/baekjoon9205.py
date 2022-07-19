import sys
from collections import deque


input = sys.stdin.readline

t= int(input())

for _ in range(t):
    n = int(input())
    dp =[]
    for i in range(n+2):
        dp.append(list(map(int,input().split())))
    visited =[False]*(n+2)

    queue = deque([[dp[0][0],dp[0][1]]])
    visited[0]=True
    while queue:
        x,y=queue.popleft()
        for i in range(n+2):
            if visited[i]==False:
                if abs(x-dp[i][0])+abs(y-dp[i][1])<=1000:
                    queue.append([dp[i][0],dp[i][1]])
                    visited[i]=True

    # print(visited[-1])
    if visited[-1]:
        print("happy")
    else:
        print("sad")
