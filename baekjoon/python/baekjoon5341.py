import sys

input = sys.stdin.readline

while True:
    temp = int(input())
    if temp==0:
        break
    else:
        print((1+temp)*temp//2)