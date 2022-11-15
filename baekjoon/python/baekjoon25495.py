import sys

input = sys.stdin.readline

n = int(input())
n_list = list(map(int,input().split()))
total = 2
last = 2
start = n_list[0]
for i in range(1,len(n_list)):
    if start==n_list[i]:
        last*=2
    else:
        start=n_list[i]
        last=2
    # print(last)
    total+=last
    if total>=100:
        last=1
        total=0
print(total)