def solution(a, b):
    result = 0
    for i in list(zip(a,b)):
        result += i[0]*i[1]
    return result