import sys

n,k=list(map(int,sys.stdin.readline().split()))

sum=1
temp=1
for i in range(k):
    temp*=(i+1)
    sum*=n
    n-=1
print(int(sum/temp))