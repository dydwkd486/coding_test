import sys

n=sys.stdin.readline().split()

result=0
for i in n:
    result+=(int(i)**2)
print(result%10)