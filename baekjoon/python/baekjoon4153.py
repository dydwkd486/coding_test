import sys

while True:
    n= list(map(int, sys.stdin.readline().split()))
    if n[0]==0 and n[1]==0 and n[2]==0:
        break
    n.sort()
    if n[0]*n[0]+n[1]*n[1]==n[2]*n[2]:
        print("right")
    else:
        print("wrong")