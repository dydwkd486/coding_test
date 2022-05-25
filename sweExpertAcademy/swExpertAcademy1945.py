# 간단한 소인수분해 9:40 -> 9:46

T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    result = []
    temp = 0
    while True:
        if n%11==0:
            temp+=1
            n=n//11
        else:
            result.append(temp)
            temp = 0
            break
    while True:
        if n%7==0:
            temp+=1
            n=n//7
        else:
            result.append(temp)
            temp = 0
            break
    while True:
        if n%5==0:
            temp+=1
            n=n//5
        else:
            result.append(temp)
            temp = 0
            break
    while True:
        if n%3==0:
            temp+=1
            n=n//3
        else:
            result.append(temp)
            temp = 0
            break
    while True:
        if n%2==0:
            temp+=1
            n=n//2
        else:
            result.append(temp)
            temp = 0
            break
    result.reverse()
    print(f"#{testCase}",end=" ")
    print(*result)

