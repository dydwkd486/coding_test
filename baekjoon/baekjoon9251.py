import sys

input= sys.stdin.readline

a= list(input().strip())
b= list(input().strip())

dp =[0 for _ in range(1001)]


for i in range(len(a)):
    count=0 
    for j in range(len(b)):
        if count<dp[j]:
            count=dp[j]
        elif a[i]==b[j]:
            dp[j]=count+1

print(max(dp))
# import sys

# input= sys.stdin.readline

# a= list(input().strip())
# b= list(input().strip())

# dp =[0 for _ in range(1001)]


# for i in range(len(a)):
#     for j in range(len(b)):
#         if a[i]==b[j]:
#             dp[j+1]=dp[j]+1
#         elif dp[j+1]<dp[j]:
#             dp[j+1]=dp[j]
#     # print(dp)
# print(max(dp))