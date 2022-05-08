import sys

input =sys.stdin.readline

n = int(input())

n_list=list(map(int,input().split()))
a= [[0,5],[1,4],[2,3]]
if n==1:
    print(sum(n_list)-max(n_list))

else:
    total=n**3-(n-2)*(n-2)*(n-1)
    n_1= min(n_list)
    temp_2=[]
    for i in range(6):
        for j in range(i+1,6):
            if [i,j] not in a:
                # print([i,j])
                # print(n_list[i]+n_list[j])
                temp_2.append(n_list[i]+n_list[j])
    n_2=min(temp_2)
    n_3= min(n_list[0],n_list[5])+min(n_list[1],n_list[4])+min(n_list[2],n_list[3])
    # print(n_1,n_2,n_3)
    # print(total,total-4-(4*(n-1)+4*(n-2)))
    # print(n_3*4,n_2*(4*(n-1)+4*(n-2)),n_1*(total-4-(4*(n-1)+4*(n-2))))
    print(n_3*4+n_2*(4*(n-1)+4*(n-2))+n_1*(total-4-(4*(n-1)+4*(n-2))))