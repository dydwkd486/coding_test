import sys

input= sys.stdin.readline

n,k= map(int,input().split())

dp = [False]*n

n_list = list(input().strip())

# print(n_list)

for i in range(len(n_list)):
    if n_list[i]=='P':
        dp[i]=True

# print(dp)
count=0
for i in range(len(n_list)):
    if n_list[i]=='P':
        for j in range(i-k,i+k+1):
            if j>=0 and j<n and dp[j]==False and n_list[j]=="H":
                dp[j]=True
                count+=1
                break
# print(dp)
print(count)