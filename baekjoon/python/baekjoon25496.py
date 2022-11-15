import sys

input = sys.stdin.readline

p,n = map(int,input().split())
a = list(map(int,input().split()))
a.sort()
count=0
# print(a)
for i in range(n):
    if p<200:
        p+=a[i]
        count+=1
    if p>=200:
        break
    
print(count)
