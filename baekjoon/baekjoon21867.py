import sys

n=int(sys.stdin.readline().split()[0])
# print(n)
s=sys.stdin.readline().split()[0]
JAVA_Bitecode=["J","A","V"]
result=[]
for i in s:
    if i not in JAVA_Bitecode:
        result.append(i)

if len(result)==0:
    print("nojava")
else:
    print("".join(result))