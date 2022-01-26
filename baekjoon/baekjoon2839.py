import sys

input = sys.stdin.readline

n= int(input())

result = 5001

n_l=n//5
for i in range(0,n_l+1):
    # print(i*5)
    if (n-(i*5))%3==0:
        # print(((n-(i*5))//3)+i)
        result= min(result,((n-(i*5))//3)+i)
if result==5001:
    print(-1)
else:
    print(result)