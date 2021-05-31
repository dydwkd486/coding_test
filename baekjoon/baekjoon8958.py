import sys

n=int(sys.stdin.readline())
result=[]
for _ in range(n):
    m=sys.stdin.readline()
    sum=0
    o_count=0
    for i in m:
        if i=='O':
            o_count=o_count+1
            sum+=o_count
        else:
            o_count=0
    result.append(sum)
for i in result:
    print(i)
