import sys

input = sys.stdin.readline

n,m = map(int,input().split())

graph = [list(map(int,input().split())) for _ in range(n)]

m_list = [list(map(int,input().split())) for _ in range(m)]

sum_data = [[0] * (n+1) for i in range(n+1)]

for i in range(1, n+1):
    for j in range(1, n+1):
        sum_data[i][j] = sum_data[i][j-1] + sum_data[i-1][j] - sum_data[i-1][j-1] + graph[i-1][j-1]

# print(m_list)

# for i in graph:
#     print(i)
# print("")

# for y in range(1,n+1):
#     for x in range(1,n+1):
#         graph[y][x] += graph[y][x-1]
# for i in graph:
#     print(i)
# print("")

for i in m_list:
    x1, y1, x2, y2 = i
    print(sum_data[x2][y2] - sum_data[x1-1][y2] - sum_data[x2][y1-1] + sum_data[x1-1][y1-1])
