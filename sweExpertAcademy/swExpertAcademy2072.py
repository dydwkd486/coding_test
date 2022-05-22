T = int(input())

for i in range(T):
    n = list(map(int,input().split()))
    result=0
    for j in n:
        if j%2 == 1:
            result+=j
    print(f"#{i+1} {result}")