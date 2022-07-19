import sys

input = sys.stdin.readline

n = int(input())
list_n=[]
for i in range(n):
    list_n.append(list(map(int,input().split())))

temp=list_n[0]
for i in range(1,len(list_n)):
    for j in range(len(list_n[i])):
        # print(len(list_n[i-1]))
        # print(j,list_n[i])
        if j==0:
            # print("처음",list_n[i][j],list_n[i-1][j])
            list_n[i][j]=list_n[i][j]+list_n[i-1][j]
        elif len(list_n[i-1])==j:
            # print("끝",list_n[i][j],list_n[i-1][j-1])
            list_n[i][j]=list_n[i][j]+list_n[i-1][j-1]
        else:
            # print("가운데")
            # print(list_n[i][j],list_n[i-1][j-1],list_n[i-1][j])
            list_n[i][j]=list_n[i][j]+max(list_n[i-1][j-1],list_n[i-1][j])
    # print("")
print(max(list_n[-1]))