# 최빈수 구하기 11:00-> 11:08
T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    n_list = list(map(int,input().split()))
    dp =[0 for _ in range(101)]
    for i in n_list:
        dp[i]+=1
    for i in range(101):
        if dp[i]==max(dp):
            result = i
    print(f"#{testCase} {result}")