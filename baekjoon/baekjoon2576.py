import sys

input = sys.stdin.readline
n=[]
result=[]
for i in range(7):
    n.append(int(input()))

for i in range(7):
    if n[i]%2==1:
        result.append(n[i])
if len(result)==0:
    print(-1)
else:
    print(sum(result))
    print(sorted(result)[0])
