import math
# 소수 판별 함수(에라토스테네스의 체)
def prime_check(n):     # n이 소수인지 아닌지 판별
    if n == 1:
        return False
    for i in range(2, int(math.sqrt(n)) + 1):
        if n%i == 0:
            return False
    return True

def solution(n, k):
    answer = 0
    temp=n
    result=""
    
    while temp>0:
        temp,m = divmod(temp,k)
        result+=str(m)
    result= result[::-1]
    
    # 소수 확인
    for i in result.split("0"):
        if i !="" and prime_check(int(i)):
            answer+=1
    
    
    return answer