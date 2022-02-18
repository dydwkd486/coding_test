import sys

input = sys.stdin.readline

a,b,c = list(map(int,input().split()))
d = int(input())
a = a+(d//3600)%24
b = b+(d//60)%60
c = c+d%60
if c>=60:
    b+=1
if b>=60:
    a+=1
print(a%24,b%60,c%60)