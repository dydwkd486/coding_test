# flatten 01:26-> 01:54
T = 10

for testCase in range(1,T+1):
    n= int(input())
    n_list = list(map(int,input().split()))
    n_count = [0 for _ in range(101)]
    min = 1
    max = 100
    for i in n_list:
        n_count[i]+=1
    while True:

        if n_count[min]<=0:
            min+=1
            continue
        if n_count[max]<=0:
            max-=1
            continue
        if n<=0:
            break
        else:
            n -= 1
        n_count[min]-=1
        n_count[min+1]+=1
        n_count[max]-=1
        n_count[max-1]+=1
    result=0
    for i in range(100,-1,-1):
        if n_count[i]!=0:
            result= i
            break
    for i in range(100):
        if n_count[i]!=0:
            result-=i
            break
    print(f"#{testCase} {result}")



