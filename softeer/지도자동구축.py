import sys

input= sys.stdin.readline

n = int(input())

n_list=[2]
for i in range(15):
    temp = n_list[i]*2-1
    n_list.append(temp)

print(n_list[n]**2)