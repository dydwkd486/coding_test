import sys

input = sys.stdin.readline

while True:
    count = 0
    n = list(input().strip().lower())
    if len(n)==1 and n[0]=="#":
        break
    else:
        for i in n:
            if i in ['a','e','i','o','u']:
                count+=1
    print(count)