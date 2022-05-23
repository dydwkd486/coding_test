T = int(input())

for testCase in range(1,T+1):
    n = list(map(int,input().split()))
    n.sort()
    print(f"#{testCase} {round(sum(n[1:-1])/len(n[1:-1]))}")
