import sys

input = sys.stdin.readline

n,m = map(int, input().split(" "))
result=0
dic={}


for i in range(n):
    temp = input().split()[0]
    dic[temp]=0

for i in range(m):
    try:
        temp = input().split()[0]
        dic[temp]=dic[temp]+1
    except:
        pass

for i in dic:
    result+=dic[i]

print(result)