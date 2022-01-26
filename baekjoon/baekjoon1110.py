import sys


input = sys.stdin.readline

n = input().strip()
if len(n)==1:
    n=n+"0"

temp=n
count=0

while True:
    if len(str(int(temp[0])+int(temp[1])))==1:
        temp=temp[1]+str(int(temp[0])+int(temp[1]))
    else:
        temp=temp[1]+str(int(temp[0])+int(temp[1]))[1]
    count+=1
    if int(temp)==int(n):
        break
print(count)
