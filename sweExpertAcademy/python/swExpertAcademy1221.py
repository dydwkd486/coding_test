# GNS  06:58 -> 07:06

T = int(input())
for testCase in range(1,T+1):
    n = list(input().split())
    n=int(n[1])
    n_dict = {"ZRO":0, "ONE":0, "TWO":0, "THR":0, "FOR":0, "FIV":0, "SIX":0, "SVN":0, "EGT":0, "NIN":0}
    n_list = list(input().split())
    for i in n_list:
        n_dict[i]+=1
    # print(n_dict)
    print(f"#{testCase}")
    for i in n_dict:
        for _ in range(n_dict[i]):
            print(i, end=" ")
    print("")