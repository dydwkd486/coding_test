import sys

input = sys.stdin.readline

n,m = map(int,input().split())
trees=list(map(int,input().split()))
# print(trees)
trees_max = max(trees)
trees_min = 1

while trees_max >= trees_min:
    mid=(trees_max+trees_min)//2
    line=0
    for i in trees:
        line += max(0,i-mid)
    if line>=m:
        trees_min=mid+1
    else:
        trees_max=mid-1
print(trees_max)