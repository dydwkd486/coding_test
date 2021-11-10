dp=[0,1]


n = int(input())

if n==0:
    print(0)
else:

    for i in range(1,n,1):
        dp.append(dp[i]+dp[i-1])

    print(dp[-1])