# 숫자를 정렬하자 10:51-> 10:54

T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    n_list = list(map(int,input().split()))
    n_list.sort()
    print(f"#{testCase}",end=" ")
    print(*n_list)