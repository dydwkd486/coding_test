from re import L
import sys

input = sys.stdin.readline

n = int(input())
n_list = list(map(int,input().split()))

for i in range(1,len(n_list)):
    for j in range(n_list[i],0,-1):
        if(n_list[0]%j==0 and n_list[i]%j==0):
            print(str(n_list[0]//j)+"/"+str(n_list[i]//j))
            break