import sys

input = sys.stdin.readline

n = int(input())

for _ in range(n):
    result = 0
    m = list(map(int,input().split()))
    print(*m)
    for i in m:
        if i>=10:
            result+=1
    if result==0:
        print("zilch")
    elif result==1:
        print("double")
    elif result==2:
        print("double-double")
    else:
        print("triple-double")
    print()