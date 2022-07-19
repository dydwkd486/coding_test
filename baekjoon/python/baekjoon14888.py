import sys
from itertools import permutations

input = sys.stdin.readline

n= int(input())
a=list(map(int,input().split()))
operator=list(map(int,input().split()))
operator_4=[]
for _ in range(operator[0]):
    operator_4.append(0)
for _ in range(operator[1]):
    operator_4.append(1)
for _ in range(operator[2]):
    operator_4.append(2)
for _ in range(operator[3]):
    operator_4.append(3)
operators_perm=list(set(permutations(operator_4,n-1)))

result_min=1000000001
result_max=-1000000001
for operator_perm in operators_perm:
    temp=a[0]
    for i in range(n-1):
        if operator_perm[i]==0:
            temp+=a[i+1]
        if operator_perm[i]==1:
            temp-=a[i+1]
        if operator_perm[i]==2:
            temp*=a[i+1]
        if operator_perm[i]==3:
            if temp<0:
                temp=-temp
                temp//=a[i+1]
                temp=-temp
            else:
                temp//=a[i+1]
    result_min=min(result_min,temp)
    result_max=max(result_max,temp)
print(result_max)
print(result_min)

