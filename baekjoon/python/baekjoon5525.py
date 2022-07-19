import sys

input= sys.stdin.readline

n = int(input())
m = int(input())
m_list = input().strip()

count = 0
i = 0
result = 0
while i < m-1:
    if m_list[i:i+3] =="IOI":
        i+=2
        count+=1
        if count==n:
            count-=1
            result+=1
    else:
        count=0
        i+=1

print(result)
