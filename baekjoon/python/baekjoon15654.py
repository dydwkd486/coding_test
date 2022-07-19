import sys
from itertools import permutations

input= sys.stdin.readline

n,m = map(int,input().split())

n_list = list(map(int,input().split()))
n_list.sort()
result =list(permutations(n_list,m))
for i in result:
    print(*i)


# import sys

# input= sys.stdin.readline
# def dfs(x,y):
#     if m==y:
#         print(*x)
#     else:
#         for i in range(0,n):
#             if n_list[i] not in x:
#                 x.append(n_list[i])
#                 dfs(x,y+1)
#                 x.pop()

# n,m = map(int,input().split())
# n_list = list(map(int,input().split()))
# n_list.sort()

# for i in range(0,n):
#     temp=[n_list[i]]
#     dfs(temp,1)