'''
기억해야할것
gcd
여러 공약수를 알아내기 위해서는 A-B,B-C 형식으로 빼고 거기서 gcd를 진행하기
제곱근을 활용하여 반복 횟수를 줄이기
'''
import sys

def GCD(a,b):
    while b:
        temp=a%b
        a=b
        b=temp
    return a

input= sys.stdin.readline

n= int(input())
n_list=[]
result=[]
for i in range(n):
    n_list.append(int(input()))
n_list.sort()

prev=n_list[1]-n_list[0]
for i in range(2,len(n_list)):
    prev = GCD(n_list[i]-n_list[i-1],prev)

for i in range(2,int(prev**(1/2))+1):
    if prev % i ==0:
        result.append(i)
        result.append(prev//i)
result.append(prev)
result=list(set(result))
result.sort()
print(*result)
