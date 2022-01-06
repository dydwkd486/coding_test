import sys

input = sys.stdin.readline


n=int(input())
result=[0,1,1]
if n==1:
    print(result[1])
elif n==2:
    print(result[2])
else:
    for i in range(2,n):
        result.append(result[i-1]+result[i])
    print(result[n])