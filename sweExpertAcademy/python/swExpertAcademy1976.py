T = int(input())

for testCase in range(1,T+1):
    h1,m1,h2,m2 = map(int,input().split())
    h = h1+h2
    m = m1+m2
    h =h%12
    h+=m//60
    m = m%60
    if h==0:
        h=1
    print(f"#{testCase} {h} {m}")