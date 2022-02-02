import sys

input = sys.stdin.readline

n=[]
result=[]
for i in range(5):
    n.append(input().split())
for i in range(15):
    for j in range(5):
        try:
            result.append(n[j][0][i])
        except:
            continue
print("".join(result))