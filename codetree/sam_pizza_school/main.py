n , k = map(int,input().split())
n_list = list(map(int,input().split()))
temp =[]

if(len(temp)<len(n_list)):
    temp1=[]
    for i in range(len(temp)-1,-1,-1):
        for j in range(len(temp[0])):
            print(temp[i][j])
            temp1.append(temp[i][j])
    del temp[1][-1]
    temp1.append(temp)
    print(temp1)

