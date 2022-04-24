import sys

w, n = map(int, sys.stdin.readline().split())
mp=[0 for _ in range(11)]
for i in range(n):
    x,y=list(map(int, sys.stdin.readline().strip().split()))
    mp[y]+=x
print(mp)

# mp=sorted(mp,reverse=True)
# print(mp)
result = 0


for i in range(len(mp)-1,0,-1):
    # print(i,mp[i])
    if w > mp[i]:
        result += mp[i]*i
        w -= mp[i]
    else:
        result += w*i
        break

print(result)