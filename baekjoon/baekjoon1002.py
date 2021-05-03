from sys import stdin
T = int(stdin.readline())
for _ in range(T):
    x1,y1,r1,x2,y2,r2=list(map(int,stdin.readline().split()))
    r=((x2-x1)**2+(y2-y1)**2)**(1/2)
    # print(r)
    a = [r1, r2,r]
    a = sorted(a)
    # print(a)
    if r==0 and r1==r2:
        print(-1)
    elif a[2]==a[0]+a[1]:
        print(1)
    elif a[2]>a[0]+a[1]:
        print(0)
    else:
        print(2)



'''
8
0 0 13 40 0 37
0 0 3 0 7 4
1 1 1 1 1 5
0 0 0 0 0 0
0 0 1 0 0 4
0 0 3 0 -7 4
-1 -7 4 1 0 3
0 0 13 -40 0 37

'''