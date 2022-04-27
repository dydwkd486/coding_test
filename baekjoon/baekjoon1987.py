import sys

nx=[0,0,1,-1]
ny=[1,-1,0,0]

def dfs(x,y,count):
    global result
    result= max(result,count)
    for i in range(4):
        dx= x+nx[i]
        dy= y+ny[i]
        if -1<dx<r and -1<dy<c and not graph[dx][dy] in alphabet:
            alphabet.add(graph[dx][dy])
            dfs(dx,dy,count+1)
            alphabet.remove(graph[dx][dy])

input= sys.stdin.readline

r,c = map(int,input().split())
graph=[]
alphabet=set()
result=0
for i in range(r):
    temp=list(input().strip())
    graph.append(temp)
# print(graph)
alphabet.add(graph[0][0])
dfs(0,0,1)
print(result)

