import sys
from collections import Counter

n=sys.stdin.readline().split()
n=n[0].upper()
# print(n)
# print(Counter(n[0]).most_common(2))
if len(Counter(n))>1:
    if Counter(n).most_common(2)[0][1]==Counter(n).most_common(2)[1][1]:
        print("?")
    else:
        print(Counter(n).most_common(1)[0][0].upper())
else:
    print(Counter(n).most_common(1)[0][0].upper())