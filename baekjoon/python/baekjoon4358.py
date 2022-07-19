import sys

input= sys.stdin.readline
total=0
trees={}
while True:
    temp =input().strip()
    if not temp:
        break
    try:
        trees[temp]+=1
    except:
        trees[temp]=1
    total+=1


for i in trees:
    trees[i]=round(trees[i]/total*100,4)

trees= sorted(trees.items())

for i in trees:
    print(f"{i[0]} {i[1]:.4f}")