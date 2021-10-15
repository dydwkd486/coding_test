# from collections import deque
# n = int(input())
# m=list(map(int,input().split(" ")))
# a,b=map(int,input().split(" "))
# queue=deque()
# print(n,m,a,b)

# def bfs(start,end):
    
#     num=0
#     while start+m[start-1]*num<=end:
#         if start+m[start-1]*num==end:
#             return "Asd"
#         else:
#             queue.appendleft(start+m[start-1]*num)
            

        
    
    
# result =bfs(a,b)
# print(result)

from collections import deque

def bfs(a, b, bridge, N):
    q = deque()
    q.append(a-1)
    check = [-1]*N
    check[a-1] = 0
    while q:
        node = q.popleft()
        for n in range(node, N, bridge[node]):
            if check[n] == -1:
                q.append(n)
                check[n] = check[node] + 1
                if n == b-1:
                    return check[n]
        for n in range(node, -1, -bridge[node]):
            if check[n] == -1:
                q.append(n)
                check[n] = check[node] + 1
                if n == b-1:
                    return check[n]
    return -1

N = int(input())
bridge = list(map(int, input().split()))
a, b = map(int, input().split())
print(bfs(a, b, bridge, N))