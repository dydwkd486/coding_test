import sys
import heapq

n= int(input())
heap=[]
for i in range(n):
    temp=int(sys.stdin.readline())
    if temp==0:
        if len(heap)==0:
            print(0)
        else:
            c=heapq.heappop(heap)
            print(c)
    else:
        heapq.heappush(heap,temp)


