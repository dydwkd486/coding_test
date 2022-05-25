# View 11:16-> 11:24 8분?
T = 10

for testCase in range(1,T+1):
    n = int(input())
    n_list = list(map(int,input().split()))
    result = 0
    for i in range(2,n-2):
        temp = max(n_list[i-2],n_list[i-1],n_list[i+1],n_list[i+2])
        if n_list[i]>temp:
            result +=n_list[i]-temp
    print(f"#{testCase} {result}")
