import sys

input = sys.stdin.readline
n=[]
for i in range(3):
    n.append(list(map(int,input().split())))

for i in range(3):
    if n[i%3][0]==n[(i+1)%3][0]:
        a=n[(i+2)%3][0]
    if n[i%3][1]==n[(i+1)%3][1]:
        b=n[(i+2)%3][1]
print(a,b)