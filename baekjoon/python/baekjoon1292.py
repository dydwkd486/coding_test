a,b = map(int,input().split())
total = []
for i in range(1,b+1):
    for j in range(i):
        total.append(i)
print(sum(total[a - 1:b]))