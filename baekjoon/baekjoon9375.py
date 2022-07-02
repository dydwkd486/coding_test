import sys
from collections import defaultdict
input = sys.stdin.readline

T = int(input())

for testCase in range(T):
    n = int(input())
    fashion = defaultdict(list)
    result=1
    for i in range(n):
        temp = list(input().split())
        fashion[temp[1]].append(temp[0])
    for i in list(fashion):
        # print(i,len(fashion[i])+1)
        result*=(len(fashion[i])+1)
    result-=1
    print(result)
    