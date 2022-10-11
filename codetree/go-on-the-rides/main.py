dx = [0,0,1,-1]
dy = [1,-1,0,0]

n = int(input())
graph = [[0]*(n+1) for _ in range(n+1)]
n_list = [list(map(int,input().split())) for _ in range(n*n)]
n_dict =dict()
for i in range(len(n_list)):
    n_dict[n_list[i][0]]=n_list[i][1:]
# print(n_dict)

# 처음에 좋아하는 사람이 있는지 파악하기
# 
for a in range(0,n*n):
    save_count = 0
    emp_count=0
    save_y=0
    save_x=0
    for i in range(1,n+1):
        for j in range(1,n+1):
            # i=y , j =x
            if(graph[i][j]!=0): continue
            temp_count = 0
            temp_emp_count =0
            for k in range(4):
                vy = i+dy[k]
                vx = j+dx[k]
                if(0<vy<n+1 and 0<vx<n+1):
                    if graph[vy][vx] in n_dict[n_list[a][0]]:
                        temp_count+=1
                    if graph[vy][vx]==0:
                        temp_emp_count+=1
            if temp_count>save_count:
                save_count = temp_count
                emp_count=0
                save_y = i
                save_x = j
            if temp_count==save_count:
                if temp_emp_count>emp_count:
                    emp_count = temp_emp_count
                    save_y = i
                    save_x = j      
    # 아무도 좋아하는 애가 없는 경우
    # 비어있는 칸이 많은 곳으로 들어감
    if save_count==0:
        save_count=-1
        for i in range(1,n+1):
            for j in range(1,n+1):
                if(graph[i][j]!=0): continue
                temp_count=0
                for k in range(4):
                    vy = i+dy[k]
                    vx = j+dx[k]
                    if(0<vy<n+1 and 0<vx<n+1):
                        if graph[vy][vx]==0:
                            temp_count+=1
                if temp_count>save_count:
                    save_count = temp_count
                    save_y = i
                    save_x = j
    graph[save_y][save_x]=n_list[a][0]
    # if n_list[a][0] == 56:
    #     for i in graph:
    #         print(i)
# 입접한 녀석 점수 얻기
score = [0,1,10,100,1000]
result =0
for i in range(1,n+1):
    for j in range(1,n+1):
        temp_count=0
        for k in range(4):
            vy = i+dy[k]
            vx = j+dx[k]
            if(0<vy<n+1 and 0<vx<n+1):
                if graph[vy][vx] in n_dict[graph[i][j]]:
                    temp_count+=1
        result+=score[temp_count]
print(result)
