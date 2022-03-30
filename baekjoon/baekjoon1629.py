import sys
# 제곱을 풀때는 분할정복을 알고있자!
def Recursive_Power(C,n):
    if n ==1:
        return C%c
    else:
        y = Recursive_Power(C,n//2)
    if n % 2==0:
        return y*y % c
    else:
        return y*y*C % c

input = sys.stdin.readline

a,b,c = list(map(int,input().split()))

# result=a

# for i in range(b-1):
#     result*=a
#     if len(str(c))<=len(str(result)):
#         result=int(str(result)[-c:])

result = Recursive_Power(a,b)

print(result)
