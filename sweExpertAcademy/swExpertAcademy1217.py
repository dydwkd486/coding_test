# 거듭제곱
# 재귀함수를 이용해서 풀것

T= 10
def asd(count):
    global result
    if count!=m:
        result = result*n
        asd(count+1)

for i in range(1,T+1):
    t = int(input())
    n,m = map(int,input().split())
    result=n
    asd(1)
    print(f"#{t} {result}")