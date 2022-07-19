import sys
from collections import deque
input = sys.stdin.readline

t= int(input())

for _ in range(t):
    a,b = map(int,input().split())
    visited=[False for _ in range(10001)]
    result=deque([[a,""]])
    while result:
        v= result.popleft()
        temp=(v[0]*2)%10000
        if temp==b:
            print(v[1]+"D")
            break
        elif visited[temp]==False:
            visited[temp]=True
            result.append([temp,v[1]+"D"])
        temp = v[0]-1
        if temp==-1:
            temp=9999
        if temp==b:
            print(v[1]+"S")
            break
        elif visited[temp]==False:
            visited[temp]=True
            result.append([temp,v[1]+"S"])
        temp=int(v[0]%1000*10+v[0]/1000)
        if temp==b:
            print(v[1]+"L")
            break
        elif visited[temp]==False:
            visited[temp]=True
            result.append([temp,v[1]+"L"])
        temp=int(v[0]%10*1000+v[0]//10)
        if temp==b:
            print(v[1]+"R")
            break
        elif visited[temp]==False:
            visited[temp]=True
            result.append([temp,v[1]+"R"])