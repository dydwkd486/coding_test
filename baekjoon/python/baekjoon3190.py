import sys
from collections import deque

input= sys.stdin.readline

count=1
n = int(input())
graph = [[0 for _ in range(n)] for _ in range(n)]

k = int(input())
for i in range(k):
    x,y=map(int,input().split())
    graph[x-1][y-1] = 1


l = int(input())
l_list={}
direction=0
nx=[0,1,0,-1]
ny=[1,0,-1,0]

for i in range(l):
    temp=input().strip().split()
    l_list[int(temp[0])]=temp[1]


queue=deque()
queue.append([0,0])
graph[0][0]=2

while True:
    v=queue[0]
    dx=v[0]+nx[direction]
    dy=v[1]+ny[direction]
    if -1<dx<n and -1<dy<n and graph[dx][dy]!=2:
        if graph[dx][dy]!=1: # 사과 존재
            tempx,tempy=queue.pop()
            graph[tempx][tempy]=0
        queue.appendleft([dx,dy])
        graph[dx][dy]=2
        if count in l_list.keys():
            if l_list[count]=='D':
                direction=(direction+1)%4
            else:
                direction=(direction-1)%4
        count+=1
    else:
        break
print(count)
    

    
    