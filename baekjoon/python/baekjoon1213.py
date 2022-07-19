import sys
from collections import deque
from collections import Counter

input = sys.stdin.readline

n = deque(list(input().strip()))
n= sorted(n)
count =Counter(n)
result=deque()
result_re=deque()
odd_bool=True
odd=""
for i in count:
    if count[i]%2==1:
        if odd!="":
            odd_bool=False
            break
        odd=i
if odd_bool==False:
    print("I'm Sorry Hansoo")
else:
    for i in count:
        result.append(i*int(count[i]/2))
    result_re= deque(reversed(result))
    if odd!="":
        result.append(odd)
    result+=result_re
    print("".join(result))