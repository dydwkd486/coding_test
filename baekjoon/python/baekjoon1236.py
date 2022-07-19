import sys

input=sys.stdin.readline

x,y= map(int,input().split())
graph = []
count_x=0
count_y=0

for i in range(x):
    temp = list(input().strip())
    if 'X' not in temp:
        count_x+=1
    graph.append(temp)

graph_trans = list(zip(*graph))
for i in graph_trans:
    if "X" not in i:
        count_y+=1
print(max(count_x,count_y))