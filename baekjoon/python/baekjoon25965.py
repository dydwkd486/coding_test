import sys

input = sys.stdin.readline

n = int(input())
for _ in range(n):
    m = int(input())
    result =0
    temp = []
    for i in range(m):
        temp.append(list(map(int,input().split())))
    k,d,a = map(int,input().split())
    for i in temp:
        K,D,A = i

        count = (k*K)-(d*D)+(a*A)
        if count>0:
            result+=count
    print(result)
