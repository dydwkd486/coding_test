# sum 04:07 -> 04:17
T = 10

for testCase in range(1,T+1):
    n = int(input())
    graph=[]
    result = 0
    for i in range(100):
        graph.append(list(map(int,input().split())))
    graph_trans= list(zip(*graph))
    for i in range(100):
        result = max(result,sum(graph[i]),sum(graph_trans[i]))
    temp = 0
    temp_reverse=0
    for i in range(100):
        temp+=graph[i][i]
        temp_reverse+=graph[i][99 - i]
    print(f"#{n} {max(result,temp,temp_reverse)}")
