import sys
from collections import deque

N = int(sys.stdin.readline())
result = [x for x in range(1, N+1)]
queue = deque(result)

while len(queue) != 1:
    queue.popleft()
    queue.append(queue.popleft())

print(queue.pop())

