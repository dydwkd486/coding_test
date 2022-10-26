import sys

input= sys.stdin.readline

a,b = map(int,input().split())
c = int(input())

temp1 = (b+c)//60
temp2 = (b+c)%60
print((temp1+a)%24,temp2)