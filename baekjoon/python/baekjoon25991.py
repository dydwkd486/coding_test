import sys

input = sys.stdin.readline

n = int(input())
n_list=list(map(float,input().split()))
count = 0
for i in n_list:
    count+=i**3
print(count**(1/3))
