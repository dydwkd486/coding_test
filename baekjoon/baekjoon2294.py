import sys

input = sys.stdin.readline

n,k = map(int,input().split())
n_list = []
result = [10001]*(k+1)
for i in range(n):
    n_list.append(int(input()))
n_list.sort()

# print(n_list)

result[0]=0

for j in n_list:
    for i in range(j,k+1):
        result[i]= min(result[i],result[i-j]+1)

if result[-1]==10001:
    print(-1)
else:
    print(result[-1])