import sys

result=[]
while True:
        x,y=map(int,sys.stdin.readline().split())
        if x==0 and y==0:
            break

        result.append(x+y)

for i in result:
    print(i)