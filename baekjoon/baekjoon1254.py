import sys

input = sys.stdin.readline

s= input().strip()

for i in range(len(s)):
    temp=s+s[:i][::-1]
    # print(temp)
    if temp==temp[::-1]:
        print(len(temp))
        break

