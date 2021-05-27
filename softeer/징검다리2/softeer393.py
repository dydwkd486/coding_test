import sys

n =int(sys.stdin.readline())
a=list(map(int,sys.stdin.readline().split()))
dp_b=[1 for i in range(n)]
dp_d=[1 for i in range(n)]

for i in range(n):
    for j in range(i):
        if a[i]>a[j]:
            dp_b[i]=max(dp_b[i],dp_b[j]+1)
    # print(len(b),cnt)

# print(dp_b)
a.reverse()
# print(a)
# print(c_1)
for i in range(n):
    for j in range(i):
        if a[i]>a[j]:
            dp_d[i]=max(dp_d[i],dp_d[j]+1)
# print(dp_d)
# print(d)
# print(c_2)
result=[]
for i in range(n):
    result.append(dp_d+dp_b)
print(max(result))


