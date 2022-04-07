from collections import deque
import sys

input = sys.stdin.readline

t= int(input())
for _ in range(t):
    p = deque(list(input().strip()))
    n= int(input())
    x=input()[1:-2]
    if len(x)!=0:
        x=deque(list(map(int,x.split(","))))
    reverse=False
    if p.count("D")>n:
        print("error")
    else:
        for i in p:
            if i=="R":
                if reverse:
                    reverse=False
                else:
                    reverse=True
            else:
                if reverse:
                    x.pop()
                else:
                    x.popleft()

        print("[",end="")
        while x:
            if reverse:
                print(x.pop(),end="")
                if x:
                    print(",",end="")
            else:
                print(x.popleft(),end="")
                if x:
                    print(",",end="")
        print("]")