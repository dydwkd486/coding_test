import sys

input= sys.stdin.readline

k,p,n = map(int,input().split())

def recursive_power(c,n):
    if n==1:
        return c
    else:
        y= recursive_power(c,n//2)%1000000007
    if n%2 ==0:
        return (y*y)%1000000007
    else:
        return (y*y*c)%1000000007
        
a= recursive_power(p,10*n)
print((k%1000000007)*(a)%1000000007)