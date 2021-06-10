import sys

n=list(map(int,sys.stdin.readline().split()))

if n[0]>100 or n[1]>100 or n[2]>200 or n[3]>200 or n[4]>300 or n[5]>300 or n[6]>400 or n[7]>400 or n[8]>500:
    print("hacker")
elif sum(n)>=100:
    print("draw")
else:
    print("none")