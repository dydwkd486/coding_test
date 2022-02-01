import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
count=0
result=[]
while True:
    count+=1
    temp = count**2
    if temp >=n and temp <= m:
        result.append(temp)
    elif temp>=m:
        break
if len(result)==0:
    print(-1)
else:
    print(sum(result))
    print(result[0])
    
