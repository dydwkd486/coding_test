import sys

input= sys.stdin.readline

n = int(input())

n_list=list(map(int,input().split()))

n_list.sort()

right = n-1
left = 0

result=n_list[left]+n_list[right]
temp=result
result_rl=[n_list[left],n_list[right]]
while left<right:
    temp= n_list[right]+n_list[left]

    if abs(result)>abs(temp):
        result = temp
        result_rl=[n_list[left],n_list[right]]
    if temp<0:
        left += 1
    else:
        right -= 1

# print(result)
print(*result_rl)
