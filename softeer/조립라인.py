import sys

input= sys.stdin.readline

n = int(input())
# a,b 라인의 처음
a,b=0,0
for i in range(n-1):
    a1,b1,c1,d1 = map(int,input().split())
    temp_b=min(a1+c1+a,b1+b) # b 라인의 최소값
    temp_a=min(b1+d1+b,a1+a) # a 라인의 최소값
    a= temp_a
    b= temp_b
c,d=map(int,input().split())
a+=c
b+=d
print(min(a,b))