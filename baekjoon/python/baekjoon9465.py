import sys

input = sys.stdin.readline

T = int(input())
for test_case in range(T):
    N = int(input())
    v1 = list(map(int,input().split()))
    v2 = list(map(int,input().split()))
    dp1=[0,v1[0]]
    dp2=[0,v2[0]]
    for i in range(0,N-1):
        dp1.append(max(dp2[i],dp2[i+1])+v1[i+1])
        dp2.append(max(dp1[i],dp1[i+1])+v2[i+1])
    print(max(dp1[-1],dp2[-1]))
