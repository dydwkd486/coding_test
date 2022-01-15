import sys

input = sys.stdin.readline

while True:
    n = int(input())
    if n==0: # 종료 시키기
        break
    n_list=[False,False]+[True]*(2*n)
    result=[1]
    
    for i in range(2,(2*n)+1):
        if n_list[i]:
            result.append(i)
            for j in range(2*i,(2*n)+1,i):
                    n_list[j]=False
    filteredList = [x for x in result if x>n]
    # print(filteredList)
    print(len(filteredList))

