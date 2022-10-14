import sys

input = sys.stdin.readline

N = int(input())
n_dict = dict()
for i in range(N*2-1):
    temp = input().strip()
    if not n_dict.get(temp):
        n_dict[temp]=1
    else:
        n_dict[temp]+=1

for i in n_dict.keys():
    if n_dict.get(i)%2==1:
        print(i)
        break