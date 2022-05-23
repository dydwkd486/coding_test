T = int(input())

for testCase in range(1, T+1):
    n,k = map(int,input().split())
    graph = []
    for i in range(n):
        graph.append(list(map(int,input().split())))
    graph_tra = list(zip(*graph))
    result =[]

    for i in range(n):
        temp = 0
        for j in graph[i]:
            if j ==1:
                temp +=1
            elif j==0 and temp !=0:
                result.append(temp)
                temp=0
        if temp !=0:
            result.append(temp)
    for i in range(n):
        temp = 0
        for j in graph_tra[i]:
            if j ==1:
                temp +=1
            elif j==0 and temp !=0:
                result.append(temp)
                temp=0
        if temp !=0:
            result.append(temp)
    print(f"#{testCase} {result.count(k)}")

