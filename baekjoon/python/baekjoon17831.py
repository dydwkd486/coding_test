import sys
sys.setrecursionlimit(1000000000)
def input():
    return sys.stdin.readline().rstrip()

def dp(v):
    con = 0
    for nei in tree[v]:
        dp(nei)
        dp_mat[v][1] += max(dp_mat[nei][0], dp_mat[nei][1])
        con = max(con, stat[v-1]*stat[nei-1] - max(dp_mat[nei][0]-dp_mat[nei][1], 0))
    dp_mat[v][0] = dp_mat[v][1]+con

n = int(input())
tree = [[] for _ in range(n+1)]

mark = list(map(int, input().split()))
for idx in range(len(mark)):
    tree[mark[idx]].append(idx+2)

stat = list(map(int, input().split()))
dp_mat = [[0,0] for _ in range(n+1)]

dp(1)
print(max(dp_mat[1]))