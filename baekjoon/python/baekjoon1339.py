import sys
from collections import deque

input = sys.stdin.readline

n = int(input())
n_list = [list(input().strip()) for _ in range(n)]
n_dic ={}
result = 0

for i in range(n):
    for j in range(len(n_list[i])):
        if n_list[i][j] in n_dic:
            n_dic[n_list[i][j]] += 10 ** (len(n_list[i])-j-1)
        else:
            n_dic[n_list[i][j]] = 10 ** (len(n_list[i])-j-1)

n_dic_list =[]
for val in n_dic.values():
    n_dic_list.append(val)

n_dic_list.sort(reverse=True)
count = 9
for i in n_dic_list:
    result+= count*i
    count-=1
print(result)
