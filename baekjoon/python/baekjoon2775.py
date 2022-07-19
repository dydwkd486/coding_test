import sys


t= int(input())
for _ in range(t):
    k=int(input()) # 층
    n=int(input()) # 호
    result=[x for x in range(1,n+1)]
    # print(result)
    for _ in range(k):
        temp=[0 for x in range(1,n+1)]
        for i in range(len(result)):
            temp[i]=sum(result[:i+1])
            # print(temp)
        result=temp
    print(result[-1])
