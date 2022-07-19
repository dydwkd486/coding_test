from ntpath import join
import sys

input = sys.stdin.readline

n = int(input())
n_list=[]
for i in range(n):
    n_list.append(list(str(input().split())))

result=[]
for i in range(len(n_list[0])):
    temp=True
    for j in range(1,n):
        if n_list[0][i]!=n_list[j][i]:
            temp=False
    if temp==True:
        result.append(n_list[0][i])
    else:
        result.append("?")
print("".join(result[2:-2]))