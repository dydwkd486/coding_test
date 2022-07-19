import sys

n_list = []

def rotation_l(gear,rotation):
    if gear!=0:
        if n_list[gear-1][2]!=n_list[gear][-2]:
            rotation_l(gear-1,-rotation)
            if -rotation==-1:
                v= n_list[gear-1].pop(0)
                n_list[gear-1].append(v)
            else:
                v= n_list[gear-1].pop(-1)
                n_list[gear-1].insert(0,v)

def rotation_r(gear,rotation):
    if gear!=3:
        if n_list[gear][2]!=n_list[gear+1][-2]:
            rotation_r(gear+1,-rotation)
            if -rotation==-1:
                v= n_list[gear+1].pop(0)
                n_list[gear+1].append(v)
            else:
                v= n_list[gear+1].pop(-1)
                n_list[gear+1].insert(0,v)
                         
input = sys.stdin.readline

for i in range(4):
    temp= list(map(int,(input().strip())))
    n_list.append(temp)

n= int(input())
result=0
for _ in range(n):
    temp = list(map(int,input().split()))
    gear = temp[0]-1
    rotation=temp[1]
    rotation_l(gear,rotation)
    rotation_r(gear,rotation)
    if rotation==-1:
        v= n_list[gear].pop(0)
        n_list[gear].append(v)
    else:
        v= n_list[gear].pop(-1)
        n_list[gear].insert(0,v)

result=n_list[0][0]+n_list[1][0]*2+n_list[2][0]*4+n_list[3][0]*8
print(result)