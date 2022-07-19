import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
n_dict = defaultdict(int)

for i in list(map(int,input().split())):
    n_dict[i]+=1

print(n_dict[int(input())])