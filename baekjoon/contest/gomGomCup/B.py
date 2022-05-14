"인사성 밝은 곰곰이"

import sys

input = sys.stdin.readline

n = int(input())
count=0
n_list=set()
for i in range(n):
    temp=input().strip()
    if temp=="ENTER":
        count+=len(n_list)
        n_list=set()
    else:
        n_list.add(temp)
count+=len(n_list)
print(count)