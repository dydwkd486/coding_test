import sys

N=int(sys.stdin.readline())
result=[]
for i in range(N):
    result.append(list(map(int,sys.stdin.readline().split())))
result.sort(key=lambda x:(x[0],x[1]))

for i in range(N):
    print(f"{result[i][0]} {result[i][1]}")