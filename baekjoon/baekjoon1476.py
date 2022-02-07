import sys

input =sys.stdin.readline

count = 1
E, S, M = map(int,input().split())

while True:
    if E%15==count%15 and S%28==count%28 and M%19==count%19:
        break
    count+=1
print(count)