import sys

N= int(sys.stdin.readline())
for _ in range(N):
    h,w,n= list(map(int,sys.stdin.readline().split()))
    # print(h,w,n)
    a= n%h
    b=int(n/h)+1
    if a==0:
        a=h
        b-=1
    print(f"{a}{b:0=2}")
