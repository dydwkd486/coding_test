import sys
import itertools
import math

n = list(map(int,input().split()))

n_comb=itertools.combinations(n,3)

result = 1000000001


def lcm(a,b):
    return a*b//math.gcd(a,b)
for i in n_comb:
    i=list(i)
    while True:
        i.append(lcm(i.pop(),i.pop()))
        if len(i) == 1:
            # print(i[0])
            result=min(result,i[0])
            break

print(result)