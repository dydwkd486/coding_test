import sys

input = sys.stdin.readline
n=[]
for i in range(5):
    n.append(list(map(int,input().split())))

result=[0,0]

for i in range(5):
    # print(n[i])
    if result[1]<sum(n[i]):
        result=[i+1,sum(n[i])]
print(*result)