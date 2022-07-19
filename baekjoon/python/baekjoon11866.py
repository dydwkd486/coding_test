import sys

n,k = list(map(int,sys.stdin.readline().split()))
count=[x for x in range(1,n+1)]
result=[]
while count:
    for i in range(k):
        c=count.pop(0)
        count.append(c)
    result.append(count.pop())
print("<",end="")
for i in range(n-1):
    print(result[i],end=", ")
print(result[n-1],end="")
print(">")
