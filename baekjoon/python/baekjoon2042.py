import sys

input = sys.stdin.readline

n,m,k= map(int, input().split())
n_list=[]
tree = [0 for _ in range(n*4)]

def init(start, end, node):
    if start == end:
        tree[node] = n_list[start]
        return tree[node]
    mid =(start+end)//2
    tree[node] = init(start,mid,node*2)+init(mid+1,end,node*2+1)
    return tree[node]

def sum(start, end, node, left, right):
    if left > end or right < start:
        return 0
    if left<=start and end <= right:
        return tree[node]
    mid = (start+end)//2
    return sum(start,mid,node*2,left,right)+sum(mid+1,end,node*2+1,left,right)

def update(start, end, node, index, dif):
    if index< start or index > end:
        return
    tree[node]+=dif
    if start == end:
        return
    mid = (start+end)//2
    update(start,mid,node*2,index,dif)
    update(mid+1,end,node*2+1,index,dif)

for i in range(n):
    n_list.append(int(input()))
init(0,n-1,1)
# print(tree)
for i in range(m+k):
    a,b,c = map(int, input().split())
    if a ==1:
        b= b-1
        diff = c- n_list[b]
        n_list[b] =c
        update(0,n-1,1,b,diff)
        # print(tree)
    elif a ==2:
        print(sum(0,n-1,1,b-1,c-1))

