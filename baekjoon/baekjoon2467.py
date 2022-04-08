import sys

input = sys.stdin.readline

n= int(input())

n_list = list(map(int,input().split()))

first=0
last=n-1
min = 2000000001
result=[]
while first<last:
    if abs(n_list[first]+n_list[last])<min:
        result=[n_list[first],n_list[last]]
        min=abs(n_list[first]+n_list[last])
    if n_list[first]+n_list[last]<0:
        first+=1
    else:
        last-=1
print(*result)