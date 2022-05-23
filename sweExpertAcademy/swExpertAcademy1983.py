T = int(input())

for testCase in range(1,T+1):
    n,k = map(int,input().split())
    n_list = []
    for i in range(1,n+1):
        temp = list(map(int,input().split()))
        result = temp[0]*0.35+temp[1]*0.45+temp[2]*0.20
        n_list.append([result,i])
    n_list.sort(reverse=True)
    print(f"#{testCase}",end=" ")
    for i in range(len(n_list)):
        if k == n_list[i][1]:
            if (n//10)*1-1>=i:
                print("A+")
            elif (n//10)*2-1>=i:
                print("A0")
            elif (n//10)*3-1>=i:
                print("A-")
            elif (n//10)*4-1>=i:
                print("B+")
            elif (n//10)*5-1>=i:
                print("B0")
            elif (n//10)*6-1>=i:
                print("B-")
            elif (n//10)*7-1>=i:
                print("C+")
            elif (n//10)*8-1>=i:
                print("C0")
            elif (n//10)*9-1>=i:
                print("C-")
            elif (n//10)*10-1>=i:
                print("D0")
            # print(n,i)
    # print(n_list)

