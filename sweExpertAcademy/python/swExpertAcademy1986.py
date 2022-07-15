T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    # 짝수
    print(f"#{testCase}",end=" ")
    if n%2 == 0:
        print(f"{-(n//2)}")
    # 홀수
    else:
        print(f"{(n//2)+1}")

