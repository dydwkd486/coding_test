n = int(input())
result=[]
for i in range(n):
    a, b =map(int,input().split(" "))
    result.append([a,b,a+b])

for i in range(n):
    print(f"Case #{i+1}: {result[i][0]} + {result[i][1]} = {result[i][2]}")