# 수도 요금 경쟁 10:49 -> 11:00
T = int(input())

for testCase in range(1,T+1):
    p,q,r,s,w = map(int,input().split())
    a = p*w
    b = q
    if (w-r)>0:
        b+=(w - r)*s
    print(f"#{testCase} {min(a,b)}")
