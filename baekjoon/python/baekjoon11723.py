import sys
n= int(input())
s=set()

for _ in range(n):
    m=sys.stdin.readline().split()
    if len(m)==1:
        if m[0] == 'all':
            s= set([i for i in range(1,21)])
        elif m[0] == 'empty':
            s=set()
    else:
        m1,m2=list(m)
        if m1=='add':
            s.add(int(m2))
        elif m1=='check':
            if int(m2) in s:
                print(1)
            else:
                print(0)
        elif m1=='remove':
            s.discard(int(m2))
        elif m1=='toggle':
            if int(m2) in s:
                s.discard(int(m2))
            else:
                s.add(int(m2))