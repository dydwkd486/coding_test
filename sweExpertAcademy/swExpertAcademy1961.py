# 숫자 배열 회전 10:56 -> 11:08

T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    graph= []
    for i in range(n):
        graph.append(list(map(int,input().split())))
    graph_t=list(zip(*graph))
    print("#"+str(testCase))
    for i in range(n):
        for j in range(n):
            print(graph_t[i][n-j-1],end="")
        print(" ",end="")
        for j in range(n):
            print(graph[n-i-1][n-j-1],end="")
        print(" ", end="")
        for j in range(n):
            print(graph_t[n-i-1][j],end="")
        print("")