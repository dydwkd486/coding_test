n = int(input())
result = []
for i in range(n+1):
    result.append(i)
result.reverse()
print(*result)