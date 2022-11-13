import sys

input = sys.stdin.readline

l = int(input())
l_list = list(map(int,input().split()))
l_list.sort()
n = int(input())
start=0
last = 1001
count=0
if n in l_list:
    print(0)
else:
    for i in range(len(l_list)):
        if l_list[i]>n:
            last = l_list[i]
            if i-1>-1:
                start = l_list[i-1]
            break
    for i in range(start+1,last):
        for j in range(i+1, last):
            if i<=n<=j:
                # print(i,j)
                count+=1
    print(count)
