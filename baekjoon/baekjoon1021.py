import sys
from collections import deque
input = sys.stdin.readline

n,m = map(int,input().split(" "))
n_list=[]
for i in range(n):
    n_list.append(i+1)

queue = deque(n_list)

solved=deque(list(map(int,input().split(" "))))

result=0
while m>0:
    temp = solved.popleft()
    if queue.index(temp)==0:
        queue.popleft()
    else:
        count=min(queue.index(temp),len(queue)-queue.index(temp))
        # print(queue.index(temp),count)
        # print(queue.index(temp),len(queue)-queue.index(temp))
        if queue.index(temp)<len(queue)-queue.index(temp):
            queue.rotate(-count)
        else:
            queue.rotate(count)
        # print(queue)
        result+=count
        queue.popleft()
    m-=1

print(result)

