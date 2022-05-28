# 농작물 수확하기 11:38 -> 11:59 21분

T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    graph = []
    result = 0

    for i in range(n):
        temp = list(input())
        graph.append(list(map(int,temp)))
    # print(graph)
    temp = 0
    for i in range(n//2+1):
        for j in range(n//2-i,n//2+i+1):
            # print(j,graph[temp][j])
            result+=graph[temp][j]
        temp+=1
    for i in range(n//2-1,-1,-1):
        for j in range(n//2-i,n//2+i+1):
            # print(j,graph[temp][j])
            result += graph[temp][j]
        temp += 1
    print(f"#{testCase} {result}")
