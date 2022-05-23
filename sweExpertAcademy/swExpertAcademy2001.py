T = int(input())

for testCase in range(1,T+1):
    n,m = map(int,input().split())
    graph = []
    dp=[]
    for i in range(n):
        graph.append(list(map(int,input().split())))
    # print(n-m+1)
    for i in range(n-m+1):
        for j in range(n-m+1):
            temp=0
            for k in range(m):
                temp+=sum(graph[i+k][j:j+m])
                # print(graph[i+k][j:j+m])
            dp.append(temp)

    print(f"#{testCase} {max(dp)}")