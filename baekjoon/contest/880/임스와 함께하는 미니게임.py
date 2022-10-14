import sys
from collections import defaultdict


input =sys.stdin.readline

N, G = input().split(" ")
N = int(N)
G = G.strip()
result = 0


n_dict = defaultdict(int)

for i in range(N):
    n_dict[input().strip()]=0

if G == "Y":
    print(len(n_dict))
elif G=="F":
    print(len(n_dict)//2)
elif G=="O":
    print(len(n_dict)//3)
