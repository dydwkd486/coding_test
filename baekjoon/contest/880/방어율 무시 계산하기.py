import sys

input = sys.stdin.readline
N = int(input())
n_list = list(map(int,input().split()))
result = 0
V = 0
for i in range(N):
    if i==0:
        V = 1-(1-V/100)*(1-n_list[i]/100)
    else:
        V = 1-(1-V)*(1-n_list[i]/100)
    print(V*100)