import sys

'''
5
55 185
58 183
88 186
60 175
46 155

'''

n = int(input())
a=[]
result=[n+1 for x in range(n)]
# print(result)
for i in range(n):
    a.append(list(map(int,sys.stdin.readline().split())))

# print(a)
for i in range(n):
    for j in range(n):
        if a[i][0]>=a[j][0] or a[i][1]>=a[j][1]:
            result[i]-=1
print(*result)
