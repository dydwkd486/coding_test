# import sys

# input= sys.stdin.readline

# n,m = map(int,input().split())
# dp = [1]
# dp_m = [1]

# for i in range(m):
#     dp.append(dp[-1]*(n-i))
#     dp_m.append(dp_m[-1]*(m-i))
# print(dp[-1]//dp_m[-1])


import sys

input= sys.stdin.readline

n,m = map(int,input().split())
dp = 1
dp_m = 1

for i in range(m):
    dp=(dp*(n-i))
    dp_m= (dp_m*(m-i))
print(dp//dp_m)