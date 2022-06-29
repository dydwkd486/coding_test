# 전기줄
import sys
from bisect import bisect_left
input = sys.stdin.readline

n = int(input())
n_list = []
for i in range(n):
    n_list.append(list(map(int,input().split())))

n_list.sort()

# dp로 풀어보기
# dp = [1]*n
# for i in range(n):
#     for j in range(i):
#         if n_list[i][1]>n_list[j][1] and dp[i]<dp[j]+1:
#             dp[i]= dp[j]+1
# print(n - max(dp))

# 이분 탐색으로 풀어보기
x= [n_list[0][1]]
dp = [1]
for i in range(1, n):
    if n_list[i][1]>x[-1]:
        x.append(n_list[i][1])
        dp.append(dp[-1]+1)
    else:
        idx = bisect_left(x,n_list[i][1])
        x[idx] = n_list[i][1]
print(n - max(dp))