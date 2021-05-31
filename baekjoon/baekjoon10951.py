import sys

result=[]
while True:
    try:
        x,y=map(int,sys.stdin.readline().split())
        result.append(x+y)
    except ValueError:
        break
for i in result:
    print(i)