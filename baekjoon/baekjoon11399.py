import sys

n=int(input())

result=0
sum1=[]
p=list(map(int,sys.stdin.readline().split()))
p.sort()

for i in range(n):
    result = result+p[i]
    sum1.append(result)

print(sum(sum1))