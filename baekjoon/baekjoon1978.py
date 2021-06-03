import sys

def is_prime_number(x):
    if x==1:
        return False
    for i in range(2,x):
        if x%i==0:
            return False

    return True

# print(is_prime_number(1000))

_=int(sys.stdin.readline())
n=list(map(int,sys.stdin.readline().split()))
result=0
for i in n:
    if is_prime_number(i):
        result+=1
print(result)
