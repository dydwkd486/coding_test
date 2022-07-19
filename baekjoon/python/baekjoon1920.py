import bisect
from sys import stdin

# def binary_search(a,b,start=0,end=None):
#     if end==None:
#         end=len(a)-1
#     if start>end:
#         return 0
#
#     mid=int((start+end)/2)
#
#     if a[mid]==b:
#         return 1
#     elif a[mid]<b:
#         start=mid+1
#     elif a[mid]>b:
#         end=mid-1
#     return binary_search(a,b,start,end)

n=int(stdin.readline())
n1=list(map(int,stdin.readline().split()))
n1.sort()
m=int(stdin.readline())
m1=list(map(int,stdin.readline().split()))

# for i in m1:
#     print(binary_search(n1,i))


for i in m1:
    j = bisect.bisect_left(n1, i)  # bisect 모듈 이용하여 이분탐색
    if j < len(n1) and n1[j] == i:
        print(1)
    else:
        print(0)