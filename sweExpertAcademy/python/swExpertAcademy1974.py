T = int(input())

for testCase in range(1,T+1):
    graph = []
    for i in range(9):
        graph.append(list(map(int,input().split())))
    graph_trans=list(zip(*graph))
    result = 1
    for i in range(9):
        for j in range(1,10):
            if j not in graph[i]:
                result = 0
                break
        if result == 0:
            break
    for i in range(9):
        for j in range(1,10):
            if j not in graph_trans[i]:
                result = 0
                break
        if result == 0:
            break

    for i in range(0,9,3):
        for j in range(0,9,3):
            temp = []
            for k in range(3):
                for n in range(3):
                    temp.append(graph[i+k][j+n])
            # print(temp)
            for k in range(1, 10):
                if k not in temp:
                    result = 0
                    break
            if result == 0:
                break
    print(f"#{testCase} {result}")

