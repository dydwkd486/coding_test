# 암호생성기 12:12 -> 12:20 8분

T = 10

for testCase in range(1,T+1):
    n = int(input())
    graph = list(map(int,input().split()))
    count=0
    while True:
        v = graph.pop(0)-(count%5+1)
        if v <=0:
            v =0
            graph.append(v)
            count += 1
            break
        graph.append(v)
        count += 1
    print(f"#{n}",end=" ")
    print(*graph)