import sys
input = sys.stdin.readline


n,k=list(map(int,input().split())) # n은 종류, k는 가치의 합
a=[]  # 동전의 가치
count=0  # 동전 개수

for i in range(n):
    a.append(int(input()))

for i in range(n-1,-1,-1): # 동전의 가치가 큰것부터 줄여나간다.
    if k//a[i]!=0: # k안에 포함이 된다면 조건문이 성립한다.
        count+=k//a[i] # k와 a의 값을 나눈 값이 동전의 개수가 된다.
        k=k%a[i] # k와 a의 나머지 값을 k로 변경한다.
# 이를 반복하면 총 n번 돌려서 결과가 추출된다.
print(count)
    
