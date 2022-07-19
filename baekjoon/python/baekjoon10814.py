import sys

N=int(sys.stdin.readline())
result=[]
for i in range(N):
    a,b=list(sys.stdin.readline().split())
    result.append([int(a),i,b])
result.sort(key=lambda i:(i[0],i[1]))
# print(result)
for i in range(N):
    print(f"{result[i][0]} {result[i][2]}")