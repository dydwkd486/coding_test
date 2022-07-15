# 삼성시의 버스 노선 04:30 ->04:43

T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    dp =[0 for _ in range(5001)]
    for _ in range(n):
        a,b = map(int,input().split())
        for i in range(a,b+1):
            dp[i]+=1
    p = int(input())
    result =[]
    for i in range(p):
        temp = int(input())
        result.append(dp[temp])
    print(f"#{testCase}",end=" ")
    print(*result)
