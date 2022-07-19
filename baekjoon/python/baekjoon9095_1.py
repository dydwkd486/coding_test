import sys

input = sys.stdin.readline

n = int(input())

for i in range(n):
    m = int(input())
    list_n=[1,2,4]
    for _ in range(m-3):
        list_n.append(sum(list_n))
        list_n.pop(0)
    if m<=3:
        print(list_n[m-1])
    else:
        print(list_n[2])