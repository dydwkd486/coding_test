import sys
from typing import Counter

input = sys.stdin.readline

n = int(input())

result=[]

for i in range(n):
    result.append(int(input()))
result.sort()
print(round(sum(result)/n)) # 산술 평균
print(result[int((n-1)/2)]) # 중앙값
counter = Counter(result)
temp=[]
for i in result:
    if counter[i]==counter.most_common(1)[0][1]:
        temp.append(i)
temp= set(temp)
temp = list(temp)
if len(temp)==1:
    print(temp[0])
else:
    temp.sort()
    print(temp[1])
print(max(result)-min(result))