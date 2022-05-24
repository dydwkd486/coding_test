# 두 개의 숫자열 11:10-> 11:19
T = int(input())

for testCase in range(1,T+1):
    a,b = map(int,input().split())
    result =[]
    if a<=b:
        n = a
        m = b
        n_list = list(map(int, input().split()))
        m_list = list(map(int, input().split()))
    else:
        n = b
        m = a
        m_list = list(map(int, input().split()))
        n_list = list(map(int, input().split()))
    for i in range(m-n+1):
        temp = 0
        for j in range(n):
            temp += n_list[j]*m_list[j+i]
        # print(temp)
        result.append(temp)
    print(f"#{testCase} {max(result)}")