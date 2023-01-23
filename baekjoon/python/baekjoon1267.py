n = int(input())
s = list(map(int, input().split()))
y = 0
m = 0
for i in s:
    y += i // 30 * 10 + 10
    m += i // 60 * 15 + 15
if y < m:
    print(f'Y {y}')
elif y > m:
    print(f'M {m}')
else:
    print(f'Y M {y}')