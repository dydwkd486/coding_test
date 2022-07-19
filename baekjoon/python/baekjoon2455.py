import sys

input = sys.stdin.readline

n = []
result=0
for i in range(4):
    n.append(list(map(int,input().split())))
temp=n[0][1]-n[0][0]
for i in range(1,4):
    temp=temp+n[i][1]-n[i][0]
    result=max(result,temp)
print(result)