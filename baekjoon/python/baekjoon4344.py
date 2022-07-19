import sys

input = sys.stdin.readline

c = int(input())

for i in range(c):
    n = list(map(int,input().split()))
    n_count = n[0]
    n_avg=sum(n[1:])//n_count
    print(f"{len([number for number in n[1:] if number>n_avg])/n_count*100:0.3f}%")