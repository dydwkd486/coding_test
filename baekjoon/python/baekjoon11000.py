import sys
import heapq

input = sys.stdin.readline

n = int(input())
n_list=[]
room = [] 
for _ in range(n):
    s,t=map(int, input().split())
    n_list.append([s,t])
n_list.sort()

heapq.heappush(room,n_list[0][1])

for i in range(1,n):
    if n_list[i][0]<room[0]:
        heapq.heappush(room,n_list[i][1])
    else:
        heapq.heappop(room)
        heapq.heappush(room,n_list[i][1])

print(len(room))