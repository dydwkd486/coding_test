import sys
from itertools import permutations
from collections import defaultdict
input = sys.stdin.readline

N = int(input())
n_list = list(map(str,input().split()))
n_dict = defaultdict(int)
for i in n_list:
    n_dict[i]+=1
result = defaultdict(int)
n_list=[]
for i in n_dict.keys():
    if n_dict[i]==1:
        n_list.append(i)
    if n_dict[i]>1:
        n_list.append(i)
        n_list.append(i)
for i in list(permutations(n_list,2)):
    if i[0][0]>i[1][1]:
        result[i[0][0]]=0
    else:
        result[i[1][1]]=0
    if i[0][1]>i[1][0]:
        result[i[0][1]]=0
    else:
        result[i[1][0]]=0


result = list(result.keys())
result.sort()
print(len(result))
print(*result)