import sys

result={}
for i in range(10):
    n=int(sys.stdin.readline())
    result[n%42]=0
print(len(result))