T = int(input())
d_list = [0,31,28,31,30,31,30,31,31,30,31,30,31]
for testCase in range(1,T+1):
    m1,d1,m2,d2 = map(int,input().split())
    if m2 == m1:
        result = d2-d1+1
    else:
        result = d_list[m1]-d1+1
        for i in range(m1+1,m2):
            result+=d_list[i]
        result+=d2
    print(f"#{testCase} {result}")
