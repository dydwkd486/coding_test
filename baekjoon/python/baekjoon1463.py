import sys

X=int(sys.stdin.readline())
dp=[x for x in range(1,X+1)]
if len(dp)>3:
    dp[0] = 0  # 1
    dp[1] = 1  # 2
    dp[2] = 1  # 2
    count = 3

    while count != X:
        temp = []

        if dp[count] % 3 == 0:
            temp.append(dp[int(count / 3)] + 1)
        if dp[count] % 2 == 0:
            temp.append(dp[int(count / 2)] + 1)
        temp.append(dp[int(count - 1)] + 1)

        dp[count] = min(temp)
        count += 1
        # print(temp)
    print(dp[-1])
else:
    if X==1:
        print(0)
    else:
        print(1)



