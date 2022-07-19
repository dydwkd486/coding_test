import sys

input= sys.stdin.readline

n,m = map(int,input().split())

dp = [False for _ in range(m+1)]

truePersonCount = list(map(int,input().split()))
truePerson=set(truePersonCount[1:])
party=[]
count = 0

for i in range(m):
    temp = list(map(int,input().split()))[1:]
    party.append(temp)

for _ in range(50):
    for i in party:
        temp = i
        tempBool = False
        for j in temp:
            if j in truePerson:
                tempBool = True
                break
        if tempBool==True:
            for j in temp:
                truePerson.add(j)
for i in party:
    temp = i
    for j in temp:
        if j in truePerson:
            break
    else:
        count+=1
print(count)
