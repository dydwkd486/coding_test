import sys
import heapq
input = sys.stdin.readline

h=[]
n = int(input())

for i in range(n):
    x = int(input())
    if x!=0:
        heapq.heappush(h,[abs(x),x])
    else:
        if len(h)==0:
            print(0)
        else:
            print(heapq.heappop(h)[1])