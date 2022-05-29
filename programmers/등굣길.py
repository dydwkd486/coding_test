def solution(m, n, puddles):
    answer = 0
    graph = [[0 for _ in range(m)] for _ in range(n)]
    
    for x,y in puddles:
        graph[y-1][x-1]=-1
    
    graph[0][0]=1
    for x in range(n):
        for y in range(m):
            # 오른쪽이 있는지 확인하기
            if graph[x][y]!=-1:
                if y+1<m and graph[x][y+1]!=-1:
                    graph[x][y+1] = (graph[x][y]+graph[x][y+1])%1000000007
                if x+1<n and graph[x+1][y]!=-1:
                    graph[x+1][y] = (graph[x][y] +graph[x+1][y])%1000000007
            
    answer=graph[n-1][m-1]
    return answer