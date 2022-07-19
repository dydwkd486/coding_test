import sys

_, X = map(int,input().split())

N = list(map(int, sys.stdin.readline().split()))

for i in N:
    if i<X:
        print(i,end=" ")