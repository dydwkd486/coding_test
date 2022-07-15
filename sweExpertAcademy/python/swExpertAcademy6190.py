# 정곤이의 단조 증가하는수 1:29 ->1:57

T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    n_list =list(map(int,input().split()))
    dp = -1
    for i in range(n-1):
        for j in range(i+1,n):
            temp = n_list[i]*n_list[j]
            if dp<temp:
                i_len=len(str(temp))
                count = 0
                for k in range(i_len):
                    temp1= temp%(10**(i_len-k))
                    temp1 = temp1//(10**(i_len-k-1))
                    # print(temp//(10**(i_len-j-1)))
                    if count <=temp1:
                        count = temp1
                    else:
                        break
                else:
                    if dp < temp:
                        dp=temp
    print(f"#{testCase} {dp}")



