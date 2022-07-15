# 최대상금
def a(n_list,k):
    temp= n_list[::]
    global result
    # print(k)
    if k == x:
        result=max(result,int(''.join(temp)))
        # print(temp,result)
    else:
        for i in range(len(temp)-1):
            for j in range(i+1,len(temp)):
                temp[i],temp[j]=temp[j],temp[i]
                if visited.get((''.join(temp),k+1),1):
                    visited[''.join(temp),k+1]=0
                    a(temp, k + 1)
                temp[i],temp[j]=temp[j],temp[i]
                # print(temp)


T = int(input())

for testCase in range(1,T+1):
    n,x = map(int,input().split())
    n_list = list(str(n))
    result = 0
    visited ={}
    # print(n_list)
    a(n_list,0)
    # print(visited)
    print(f"#{testCase} {result}")
