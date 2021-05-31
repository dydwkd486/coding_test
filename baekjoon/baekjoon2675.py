import sys

t = int(sys.stdin.readline())
result=[]
for i in range(t):
    r,s=sys.stdin.readline().split()
    sum=""
    for j in s:
        sum+=j*int(r)
    result.append(sum)

for i in range(len(result)):
    print(result[i])