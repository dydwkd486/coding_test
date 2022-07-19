import sys

input = sys.stdin.readline

def init(start,end,node):
    if start==end:
        segment[node]=[n_list[start],n_list[start]]
        return segment[node]
    mid = (start+end)//2
    a= init(start,mid,node*2)
    b= init(mid+1,end,node*2+1)
    max_node = max(a[1],b[1])
    min_node = min(a[0],b[0])
    segment[node] = [min_node,max_node]
    return segment[node]

def query(start,end,node,left,right):
    if left>end or right < start:
        return [10**10,0]
    if left<=start and end<=right:
        return segment[node]
    mid = (start+end)//2
    a= query(start,mid,node*2,left,right)
    b= query(mid+1,end,node*2+1,left,right)
    # print(a,b)
    max_node = max(a[1],b[1])
    min_node = min(a[0],b[0])
    return [min_node,max_node]

n,m = map(int,input().split())
n_list = []
segment=[[0,0] for _ in range(4*n)]

for _ in range(n):
    temp = int(input())
    n_list.append(temp)
init(0,n-1,1)
for _ in range(m):
    b,c = map(int,input().split())
    print(*query(0,n-1,1,b-1,c-1))
