import sys

n = int(sys.stdin.readline())
i=[]
for _ in range(n):
    x,y=map(int,sys.stdin.readline().split())
    i.append([x,y])
i= sorted(i, key=lambda x:(x[1],x[0]))
# print(i)
start=0
count=0

for j in i:
    if j[0]>=start:
        start=j[1]
        count+=1

print(count)