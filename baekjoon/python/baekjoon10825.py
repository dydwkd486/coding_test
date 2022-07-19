import sys

input = sys.stdin.readline

n = int(input())
result=[]
for i in range(n):
    temp = input().split(" ")
    result.append({"name":temp[0],"a":int(temp[1]),"b":int(temp[2]),"c":int(temp[3].replace("\n",""))})

result = sorted(result, key=lambda e : (-e["a"],e["b"],-e["c"],e["name"]))
for i in result:
    print(i["name"])