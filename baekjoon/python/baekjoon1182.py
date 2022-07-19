import sys

input = sys.stdin.readline
n, s = map(int, input().split())
s_list = list(map(int, input().split()))
count = 0

def dfs(i,sum):
    global count
    if i>=n:
        return
    sum+=s_list[i]
    if sum == s:
        count+=1
    dfs(i+1,sum-s_list[i])
    dfs(i+1,sum)

dfs(0,0)
print(count)
