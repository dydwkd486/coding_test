# import sys
# from itertools import combinations

# input= sys.stdin.readline

# n,m = map(int,input().split())

# n_list = [i for i in range(1,n+1)]
# result =list(combinations(n_list,m))
# for i in result:
#     print(*i)


import sys

input= sys.stdin.readline
def dfs(x,y):
    if m==y:
        print(*x)
    else:
        for i in range(x[-1]+1,n+1):
            x.append(i)
            dfs(x,y+1)
            x.pop()

n,m = map(int,input().split())


for i in range(1,n+1):
    temp=[i]
    dfs(temp,1)