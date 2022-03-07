import sys

input = sys.stdin.readline


n = input().split("-")
result=[]
for i in n:
    result.append(i[0])
print("".join(result))