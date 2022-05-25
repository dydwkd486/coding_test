# 간단한 압축 풀기 09:32 -> 09:39

T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    dp= []
    for i in range(n):
        x,y = list(input().split())
        dp+=x*int(y)
    # print(dp)
    print(f"#{testCase}")
    for i in range(len(dp)):
        if i%10==0 and i!=0:
            print("")
        print(dp[i],end="")
    print("")
