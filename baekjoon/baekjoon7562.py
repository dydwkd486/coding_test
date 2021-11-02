import sys
from collections import deque
input= sys.stdin.readline

xd=[-2,-2,-1,-1,1,1,2,2]
yd=[1,-1,2,-2,2,-2,1,-1]

def BFS(start,end):
    queue=deque()
    queue.append(start)
    while queue:
        temp=queue.popleft()
        if temp==end:
            return temp
        if check[temp[0]][temp[1]]==False:
            check[temp[0]][temp[1]]=True
            for i in range(8):
                temp_x=temp[0]+xd[i]
                temp_y=temp[1]+yd[i]
                if temp_x>=0 and temp_x<L and temp_y>=0 and temp_y<L:
                    chess_list[temp_x][temp_y]=chess_list[temp[0]][temp[1]]+1
                    queue.append([temp_x,temp_y])


n=int(input())
for _ in range(n):
    L=int(input())
    chess_list=[]
    check=[]
    for i in range(L):
        temp=[]
        temp_check=[]
        for j in range(L):
            temp.append(0)
            temp_check.append(False)
        chess_list.append(temp)
        check.append(temp_check)
    start_chess=list(map(int,input().split(" ")))
    end_chess=list(map(int,input().split(" ")))
    # print(start_chess)
    x,y=BFS(start_chess,end_chess)
    print(chess_list[x][y])

    