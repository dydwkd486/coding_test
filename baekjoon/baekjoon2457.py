# import sys
#
# '''
# 5
# 1 1 5 31
# 1 1 8 15
# 8 15 11 31
# 6 10 12 10
# 6 20 12 10
# '''
#
# n= int(input())
# result=[]
# max=1201
# min=301
# count=0
# for i in range(n):
#     a,b,c,d=list(map(int,sys.stdin.readline().split()))
#     result.append([a*100+b,c*100+d])
#
# result.sort(key=lambda x:(x[0],x[1]))
#
# temp=0
# while min<max:
#     # print(result)
#     h=min
#     j=0
#     k=0
#     i=0
#     while result[i][0] <= h and len(result)-1>i:
#         if result[i][1]-h>=j:
#             min=result[i][1]
#             j=result[i][1]-h
#             k=i
#         i+=1
#     for _ in range(k+1):
#         result.pop(0)
#     # print(result)
#     if j==0:
#         count=0
#         break
#     count+=1
#     # print(temp, min)
#     # print(count)
# print(count)

import sys

accumulation={1:0, 2:31, 3:59, 4:90, 5:120, 6:151, 7:181, 8:212, 9:243, 10:273, 11:304, 12:334}
def md_to_d(month, day):
    return accumulation[month]+day

flowers=[]
N=int(sys.stdin.readline())

for i in range(N):
    start_month, start_day, end_month, end_day=map(int, sys.stdin.readline().split())
    flowers.append((md_to_d(start_month, start_day), md_to_d(end_month, end_day)))
selected=[]
start=0
end=60
startdate=60
enddate=334
flowers.sort(key=lambda x:(x[0], x[1]))
x=-1
temp=0
changed=0
selected=[]
while end<=enddate and x<N:
    changed=0
    x+=1
    for i in range(x, N):
        if flowers[i][0]>end:
            break
        if temp<flowers[i][1]:
            temp=flowers[i][1]
            x=i
            changed=1
    if changed==1:
        end=temp
        selected.append(flowers[x])
    else:
        selected=[]
        break
print(len(selected))

