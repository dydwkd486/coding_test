import sys

input = sys.stdin.readline

n = int(input())
lope=[]

for i in range(n):
    lope.append(int(input()))

lope.sort(reverse=True)
count=n
result=int(lope[count-1]*count)
for i in range(n-1):
    lope.pop()
    count-=1
    if result<int(lope[count-1]*count):
        result=int(lope[count-1]*count)
print(result)