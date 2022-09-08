import sys

input = sys.stdin.readline

def boundary(x,y,d1,d2,count_graph):
    for i in range(d1+1):
        for j in range(d2+1):
            count_graph[x+i-1][y-i-1] = 5
            count_graph[x+j-1][y+j-1] = 5
            count_graph[x+d1+j-1][y-d1+j-1] = 5
            count_graph[x+d2+i-1][y+d2-i-1] = 5
    for i in range(x,x+d1+d2-1):
        temp = False
        for j in range(len(count_graph)):
            if count_graph[i][j] == 5:
                temp = True if temp==False else False
            if temp == True:
                count_graph[i][j]=5

def print_graph(i):
    for j in i:
        print(j)

def graph_sum(graph,count_graph,count):
    count_sum =0
    for i in range(len(count_graph)):
        for j in range(len(count_graph)):
            if count_graph[i][j] == count:
                count_sum+=graph[i][j]
    return count_sum


n = int(input())
graph = [list(map(int,input().split())) for _ in range(n)]
result =2e19
# 1. 기준점 x,y 와 경계의 길이 d1, d2를 정한다.
# d1,d2 >= 1
# 0<=x<x+d1+d2<n
# 0<=y-d1<y<y+d2<n

for x in range(n):
    for y in range(n):
        for d1 in range(1,n):
            for d2 in range(1,n):
                if 1<=x+d1+d2<=n and 1<=y-d1<y<y+d2<=n:
                    n_min_max_list =[0]*5
                    count_graph = [[0]*n for _ in range(n)]
                    boundary(x,y,d1,d2,count_graph)
                    for i in range(n+1):
                        for j in range(n+1):
                            if 1<=i<x+d1 and 1<=j<=y:
                                if(count_graph[i-1][j-1]==0):
                                    n_min_max_list[0] += graph[i-1][j-1]
                            elif 1<=i<=x+d2 and y<j<=n:
                                if(count_graph[i-1][j-1]==0):
                                    n_min_max_list[1] += graph[i-1][j-1]
                            elif x+d1<=i<=n and 1<=j<y-d1+d2:
                                if(count_graph[i-1][j-1]==0):
                                    n_min_max_list[2] += graph[i-1][j-1] 
                            elif x+d2<i<=n and y-d1+d2<=j<=n:
                                if(count_graph[i-1][j-1]==0):
                                    n_min_max_list[3] += graph[i-1][j-1]
                            if count_graph[i-1][j-1]==5:
                                n_min_max_list[4] += graph[i-1][j-1]
                    result = min(result , max(n_min_max_list)-min(n_min_max_list))
print(result)