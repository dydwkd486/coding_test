import sys

input = sys.stdin.readline

n = int(input())
n_list={}
for i in range(n):
    temp = list(input().strip().split(" "))
    tree=[]
    for i in range(2):
            tree.append(temp[i+1])
    n_list[temp[0]]=tree


# 재귀함수
def front(x):
    if x != '.':
        print(x,end="")
        front(n_list[x][0])
        front(n_list[x][1])

def mid(x):
    if x != '.':
        mid(n_list[x][0])
        print(x,end="")
        mid(n_list[x][1])

def back(x):
    if x != '.':
        back(n_list[x][0])
        back(n_list[x][1])
        print(x,end="")

front("A")
print("")
mid("A")
print("")
back("A")