import sys
timer=[[True,True,True,False,True,True,True], # 0
[False,False,True,False,False,True,False], # 1 
[True,False,True,True,True,False,True], # 2
[True,False,True,True,False,True,True], # 3
[False,True,True,True,False,True,False], # 4
[True,True,False,True,False,True,True], #5
[True,True,False,True,True,True,True], # 6
[True,True,True,False,False,True,False], #7
[True,True,True,True,True,True,True], #8
[True,True,True,True,False,True,True], #9
[False,False,False,False,False,False,False]] #

input = sys.stdin.readline
t = int(input())
for i in range(t):
    a,b=map(int,input().split())
    temp_a=[]
    temp_b=[]
    count=0
    for _ in range(5-len(str(a))):
        temp_a.append(timer[10])
    for i in str(a):
        temp_a.append(timer[int(i)])
    for _ in range(5-len(str(b))):
        temp_b.append(timer[10])
    for i in str(b):
        temp_b.append(timer[int(i)])
    for i in range(5):
        for j in range(7):
            if temp_a[i][j]!=temp_b[i][j]:
                count+=1
    print(count)