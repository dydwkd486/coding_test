import sys

input = sys.stdin.readline

a,b = list(map(int,input().split()))

result=[b]

while True:
    if result[-1]%2==0 and result[-1]!=0:
        result.append(result[-1]//2)
    elif result[-1]%10==1:
        result.append(result[-1]//10)
    else:
        break
if result.count(a):
    print(result.index(a)+1)
else:
    print(-1)
    

