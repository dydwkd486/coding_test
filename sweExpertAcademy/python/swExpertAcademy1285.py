# 아름이의 돌 던지기 10:31 => 10:36
T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    result = []
    min = 100001
    n_list = list(map(int,input().split()))

    for i in range(n):
        if abs(n_list[i])<min:
            min = abs(n_list[i])
        result.append(abs(n_list[i]))
    print(f"#{testCase} {min} {result.count(min)}")