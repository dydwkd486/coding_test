n = int(input())
a,b=1,1
result=0
if n==1:
    print(1)
elif n==2:
    print(2)
else:
    for i in range(n-2):
        temp=a
        a=b
        b=b+temp
    print((a+b)%10007)
