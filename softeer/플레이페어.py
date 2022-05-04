import sys

input= sys.stdin.readline
al="abcdefghiklmnopqrstuvwxyz"
n=list(input().strip())
m=set(input().strip())
for i in al:
    if i.upper() not in m:
        m.add(i.upper())
# print(n,m)
m=list(m)
graph=[]

for i in range(5):
    temp=[]
    for j in range(5):
        temp.append(m[i*5+j])
    graph.append(temp)


row_graph = list(map(list, zip(*graph)))
n_list=[]

while n:
    if len(n)==1:
        n_list.append([n[0],"X"])
        n.pop(0)
    else:
        if n[0]==n[1]:
            if n[0]=="X":
                n_list.append([n[0],"Q"])
            else:
                n_list.append([n[0],"X"])
            n.pop(0)
        else:
            n_list.append([n[0],n[1]])
            n.pop(0)
            n.pop(0)
            
for i in range(len(n_list)):
    temp=[]
    for j in range(5):
        if n_list[i][0] in graph[j]:
            temp=[j,graph[j].index(n_list[i][0])]

    if  n_list[i][1] in graph[temp[0]]:
            n_list[i][0] = graph[temp[0]][(graph[temp[0]].index(n_list[i][0])+1)%5]
            n_list[i][1] = graph[temp[0]][(graph[temp[0]].index(n_list[i][1])+1)%5]

    elif  n_list[i][1] in row_graph[temp[1]]:
            n_list[i][0] = row_graph[temp[1]][(row_graph[temp[1]].index(n_list[i][0])+1)%5]
            n_list[i][1] = row_graph[temp[1]][(row_graph[temp[1]].index(n_list[i][1])+1)%5]

    else:
        for j in range(5):
            for k in range(5):
                if graph[j][k]==n_list[i][1]:
                    if j!=temp[0] and k!=temp[1]:
                        n_list[i][0]= graph[temp[0]][k]
                        n_list[i][1]= graph[j][temp[1]]
for i in n_list:
    for j in i:
        print(j,end="")