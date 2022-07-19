import sys
from itertools import combinations

input= sys.stdin.readline

love=['L','O','V','E']
teamname = input().strip()

n = int(input())
ename = []
result=[]
for i in range(n):
    ename.append(str(input().strip()))
ename.sort()

for j in range(n):
    temp=[]
    temp_count=[]
    temp_a=1
    for i in love:
        temp.append(ename[j].count(i)+teamname.count(i))
    for i in list(combinations(temp,2)):
        temp_count.append(i[0]+i[1])
    for i in temp_count:
        temp_a*=i
    result.append(temp_a%100)

print(ename[result.index(max(result))])