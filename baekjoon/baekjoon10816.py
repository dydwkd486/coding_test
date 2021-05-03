from sys import stdin

val={}
N=input()
cards = list(map(int, stdin.readline().split()))

M=input()
problems=list(map(int, stdin.readline().split()))

for i in cards:
    if i not in val:
        val[i]=1
    else:
        val[i]+=1
# print(val)

