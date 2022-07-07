import sys

input = sys.stdin.readline

n_list = [int(input()) for _ in range(28)]

for i in range(1,30+1):
    if i not in n_list:
        print(i)