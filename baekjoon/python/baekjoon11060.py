import sys
input = sys.stdin.readline

n = int(input())
miro=list(map(int,input().split()))

miro.reverse()
count=0
while True:
    if len(miro)==1:
        break
    temp = 0
    for i in range(len(miro)):
        if i<=miro[i]:
            temp=i
    miro=miro[temp:]
    count+=1

    if temp==0:
        count=-1
        break
print(count)
