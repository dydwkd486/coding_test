# 한빈이와 spot mart 09:27 -> 09:39
T = int(input())

for testCase in range(1,T+1):
    n,m = map(int,input().split())
    n_list = list(map(int,input().split()))
    n_list.sort()
    i,j=0,n-1
    result = -1
    while i<j:
        temp = n_list[i]+n_list[j]
        if temp>m:
            j-=1
        elif temp<m:
            result = max(result, temp)
            i+=1
        elif temp==m:
            result=m
            break
    print(result)
