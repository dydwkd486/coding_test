import sys

n=int(sys.stdin.readline())

m=list(map(int,sys.stdin.readline().split()))
M=max(m)
result=[]
# m.remove(m.index(M))
for i in range(n):
    result.append(m[i]/M*100)
# print(result)
print(sum(result)/n)