# 단순 2진 암호코드 07:06 -> 08:32 밥먹고 옴

T = int(input())
for testCase in range(1,T+1):
    n,m = map(int,input().split())
    n_list=[]
    code = ["0001101","0011001","0010011","0111101","0100011","0110001","0101111","0111011","0110111","0001011"]
    for i in range(n):
        temp = list(map(int,list(input())))
        # print(temp.count(1))
        if temp.count(1)!=0:
            # print(temp)
            for j in range(m-1,m-55,-1):
                if temp[j]==1:
                    # print(temp[j-55:j+1],len(temp[j-55:j+1]))
                    n_list.append(temp[j-55:j+1])
                    break

    for i in n_list:
        result = []
        for j in range(8):
            temp= ''.join(list(map(str,i[j*7:j*7+7])))
            # print(code.index(temp))
            result.append(code.index(temp))
            # print(''.join(list(map(str,i[j*7:j*7+7]))))
        # print(result,len(n_list))
    # print(((result[0]+result[2]+result[4]+result[6])*3) +(result[1]+result[3]+result[5])+len(n_list))
    print(f"#{testCase}",end=" ")
    if (((result[0]+result[2]+result[4]+result[6])*3) +(result[1]+result[3]+result[5])+result[7])%10==0:
        print(((result[0]+result[2]+result[4]+result[6])) +(result[1]+result[3]+result[5])+result[7])
    else:
        print(0)


