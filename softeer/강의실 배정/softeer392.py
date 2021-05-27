import sys
import heapq
n = int(sys.stdin.readline())
i=[]
for _ in range(n):
    x,y=map(int,sys.stdin.readline().split())
    heapq.heappush(i,(y,x))


# print(i)
start=-1
count=0

while i:
    j=heapq.heappop(i)
    if j[1]>=start:
        start=j[0]
        count+=1
print(count)