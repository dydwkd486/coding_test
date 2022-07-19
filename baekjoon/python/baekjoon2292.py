n = int(input())

result=1
total=1

while True:
    total+=6*(result-1)
    if n<=total:
        break
    result+=1
print(result)