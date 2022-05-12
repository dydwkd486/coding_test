def solution(triangle):
    dp = [[0]*(i+1) for i in range(len(triangle))]
    dp[0][0] = triangle[0][0]
    for i in range(len(triangle)):
        for j in range(i):
            temp=dp[i-1][j]
            dp[i][j]=max(dp[i][j],temp+triangle[i][j])
            dp[i][j+1]=max(dp[i][j+1],temp+triangle[i][j+1])

    return max(dp[-1])