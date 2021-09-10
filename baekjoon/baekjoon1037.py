import sys

N=int(input())
a_list=list(map(int, sys.stdin.readline().split()))
a_list.sort()
if N%2==0: #짝수
    print(a_list[0]*a_list[-1])
else:
    print(a_list[int(len(a_list)/2)]**2)
