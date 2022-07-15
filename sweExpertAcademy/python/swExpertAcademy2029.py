T = int(input())
for testCase in range(1,T+1):
    a,b = map(int,input().split())
    print(f"#{testCase} {a//b} {a%b}")