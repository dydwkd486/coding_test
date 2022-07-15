T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    n_list = list(map(int,input().split()))
    result=0
    while n_list:
        n_max = max(n_list)
        for i in range(len(n_list)):
            if n_max == n_list[i]:
                temp = i
        result_1 = sum(n_list[:temp])

        result_1 = (temp) * n_max -result_1
        # print(result_1)
        result+=result_1
        n_list=n_list[temp+1:]
    print(f"#{testCase} {result}")
