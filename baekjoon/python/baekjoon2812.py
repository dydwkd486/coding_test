import sys

n, k = map(int, sys.stdin.readline().split())
num = str(sys.stdin.readline().split()[0])
# print(num[k:])
k1=k
result=[]
for i in range(n):
    while k1>0 and result and result[-1]<num[i]:
        del result[-1]
        k1-=1
    result.append(num[i])
print(''.join(result[:n-k]))