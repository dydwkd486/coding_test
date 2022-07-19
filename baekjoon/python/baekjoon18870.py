import sys
from collections import deque

'''
5
2 4 -10 4 -9
'''

n= int(sys.stdin.readline())

n_list=list(map(int,sys.stdin.readline().split()))
result=sorted(set(n_list))
solved= {result[i]:i for i in range(len(result))}
print(*[solved[i] for i in n_list])
