T = int(input())

for testCase in range(1,T+1):
    n = input()
    n_reverse = "".join(list(reversed(n)))
    print(f"#{testCase}",end=" ")
    if n==n_reverse:
        print("1")
    else:
        print("0")