import sys

a,b= list(map(int,sys.stdin.readline().split()))
min=1
x=2
while True:
    if a%x==0 and b%x==0:
        min*=x
        a=int(a/x)
        b=int(b/x)
        x=2
    else:
        x+=1
    if x>a or x>b:
        break
max=a*b*min
print(min)
print(max)

