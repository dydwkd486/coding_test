# 진기의 최고급 붕어빵 12:30 -> 12:57 27분

T = int(input())

for testCase in range(1,T+1):
    n,m,k= map(int,input().split())
    n_list=list(map(int,input().split()))
    n_list.sort()
    count =0
    for i in range(0,20000):
        while True:
            if len(n_list)!=0 and n_list[0]==i:
                count-=1
                n_list.pop(0)
            else:
                break
        # print(i,len(n_list),count)

        if i%m==0 and i!=0:
            count+=k

        if count<0:
            print(f"#{testCase} Impossible")
            break
        if len(n_list)==0:
            print(f"#{testCase} Possible")
            break




