"치킨댄스를 추는 곰곰이를 본 임스"

import sys

input = sys.stdin.readline

n= int(input())

a,b = map(int,input().split())

total= a//2+b
if n<total:
    print(n)
else:
    print(total)