import sys
import itertools

input = sys.stdin.readline

n ,m = map(int,input().split(" "))

count = [x for x in range(1,n+1)]

result = list(itertools.permutations(count,m))

for i in range(len(result)):
    print(*result[i])