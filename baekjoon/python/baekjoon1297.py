import sys

input = sys.stdin.readline

d,h,w =list(map(int,input().split()))

d2=d*d
h2=h*h
w2=w*w
result= d2/(h2+w2)
result= result**0.5
print(int(result*h),int(result*w))