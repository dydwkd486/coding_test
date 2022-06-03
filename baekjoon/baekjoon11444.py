# 직접 다시 한번 풀어보기
import sys

input=sys.stdin.readline

def power(adj,n):
    if n==1:
        return adj
    elif n%2:
        return multi(power(adj,n-1),adj)
    else:
        return power(multi(adj,adj),n//2)
#행렬의 곱셈
def multi(a,b):
    temp=[[0]*len(b[0]) for _ in range(2)]
    for i in range(2):
        for j in range(len(b[0])):
            sum=0
            for k in range(2):
                sum+=a[i][k]*b[k][j]
            temp[i][j]=sum%1000000007
    return temp


dp = [0,1,1]

#초기 행렬
adj=[[1,1],[1,0]]
#피보나치 초기값
start=[[1],[1]]
n=int(input())

if n<3:
    print(1)
else:
    print(multi(power(adj,n-2),start)[0][0])