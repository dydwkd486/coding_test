# import sys
# sys.setrecursionlimit(100000)
dx = [0,0,-1,-1,-1,0,1,1,1] # ↑, ↖, ←, ↙, ↓, ↘, →, ↗
dy = [0,-1,-1,0,1,1,1,0,-1]

N = int(input())
rotate = [list(map(int,input().split())) for _ in range(8)]
n_list = [list(map(int,input().split())) for _ in range(N)] # 이거 계산할때 1씩 빼줘야함.!
graph =[[0]*4 for _ in range(100)]
result =0
def block_stack(k,c,graph):
    for i in range(100):
        if graph[100-1-i][c]==0:
            graph[100-1-i][c]+=(k+1)
            break
    return

def bolck_bomb(graph,sum):
    for i in range(100):
        count=0
        for j in range(4):
            if graph[100-1-i][j] != 0:
                count+=1
        if count==4: # 마지막 줄 파괴 중력 이동
            for k in range(4):
                graph[100-1-i][k] = 0
            sum+=1
    return gravity(graph),sum

def gravity(graph):
    temp = [[0]*4 for _ in range(100)]
    for i in range(4):
        start = 0
        for j in range(100):
            if graph[100-1-j][i] !=0:
                temp[100-1-start][i] = graph[100-1-j][i]
                start+=1
    return temp

def block_change(graph):
    temp = [[0]*4 for _ in range(100)]
    for i in range(100):
        for j in range(4):
            if graph[100-1-i][j] !=0:
                for k in range(0,8):
                    vy,vx = 100-1-i+dy[rotate[graph[100-1-i][j]-1][k]],j+dx[rotate[graph[100-1-i][j]-1][k]]
                    if -1<vy<100 and -1<vx<4:
                        if temp[vy][vx]==0:
                            temp[vy][vx] = graph[100-1-i][j]
                        else:
                            temp[vy][vx] = min(graph[100-1-i][j],temp[vy][vx])
                        break # 최초 한번 이동
    return gravity(temp)


def req(count,sum,graph):
    global result
    temp_graph = [[graph[j][i] for i in range(4)] for j in range(100)]

    if count==N:
        # 여기서 최대값확인하기

        result = max(result,sum)
        
        return
    else:
        k,c = n_list[count]
        if c==0: # 여러개 인 경우!
            for i in range(1,5):
                temp_graph = [[graph[j][i] for i in range(4)] for j in range(100)]
                temp = sum
                block_stack(k-1,i-1,temp_graph)
                temp_graph,temp = bolck_bomb(temp_graph,temp)
                temp_graph = block_change(temp_graph)
                temp_graph,temp = bolck_bomb(temp_graph,temp)
                req(count+1,temp,temp_graph)
        else:
            temp = sum
            block_stack(k-1,c-1,temp_graph)
            temp_graph,temp = bolck_bomb(temp_graph,temp)
            temp_graph = block_change(temp_graph)
            temp_graph,temp = bolck_bomb(temp_graph,temp)
            req(count+1,temp,temp_graph)

# 계속 쌓는다.
req(0,0,graph)
print(result)

# 위치에 쌓는다.
# 1자로 부쉴수 있는지 확인한다. -> 맨 마지막 줄만 확인하면 됨.
# 자리 이동을 한다