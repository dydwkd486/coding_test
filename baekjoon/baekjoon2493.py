import sys

input= sys.stdin.readline

n = int(input())

n_list = list(map(int,input().split()))
stack=[]
result = [0]*n

for i in range(n):
    v= n_list[i]
    while stack and n_list[stack[-1]]<v:
        stack.pop()
    if stack:
        result[i]=stack[-1]+1
    stack.append(i)
print(*result)
