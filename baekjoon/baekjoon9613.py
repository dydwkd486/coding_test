import sys
import math

input= sys.stdin.readline
n = int(input())

for _ in range(n):
    result=0
    case= list(map(int,input().split(" ")))
    for i in range(1,case[0]):
        for j in range(i+1,case[0]+1):
            result+=math.gcd(case[i],case[j])
    print(result)
