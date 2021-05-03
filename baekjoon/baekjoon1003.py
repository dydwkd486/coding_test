
t=int(input())
for i in range(t):
    n=int(input())
    if n==0:
        print(1,0)
    elif n==1:
        print(0,1)
    else:
        dp = [[] for i in range(n+1)]
        dp[0]=[1,0]
        dp[1]=[0,1]
        for i in range(2,n+1):
            dp[i]=[dp[i-1][0]+dp[i-2][0],dp[i-1][1]+dp[i-2][1]]
        print(dp[-1][0],dp[-1][1])


