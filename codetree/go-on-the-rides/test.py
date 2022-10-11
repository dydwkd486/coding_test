from collections import defaultdict
n = int(input())
students = []
for i in range(n*n):
    students.append(list(map(int, input().split())))

move_x = [-1,0,1,0]
move_y = [0,1,0,-1]

board = [[0 for _ in range(n)] for __ in range(n)]

final_dict = defaultdict(dict)

def search_and_place(arr):
    target = arr[0]
    likes = arr[1:]
    check_dict = defaultdict(int)
    for like in likes:
        check_dict[like] = 1
    final_dict[target] = check_dict
    count = []
    for i in range(n):
        for j in range(n):
            if board[i][j] == 0:
                temp_cnt = 0
                temp_likes = 0
                temp_empty = 0
                for s,t in zip(move_x, move_y):
                    nx,ny= i+s,j+t
                    if 0<=nx<=n-1 and 0<=ny<=n-1:
                        if check_dict[board[nx][ny]] == 1:
                            temp_likes += 1
                        if board[nx][ny] == 0:
                            temp_empty += 1
                count.append([temp_likes, temp_empty, i,j])
    count = sorted(count, key = lambda x:(-x[0], -x[1], x[2],x[3]))
    _,_,x,y = count[0]
    board[x][y] = target

def calculate():
    total_score = 0
    score_board = [0,1,10,100,1000]
    for i in range(n):
        for j in range(n):
            target = board[i][j]
            target_dict = final_dict[target]
            cnt = 0
            for s,t in zip(move_x, move_y):
                nx, ny = i+s, j+t
                if 0<=nx<=n-1 and 0<=ny<=n-1:
                    neighbor = board[nx][ny]
                    if target_dict[neighbor] == 1:
                        cnt += 1
            total_score += score_board[cnt]

    print(total_score)
 

for student in students:
    search_and_place(student)
    
    if student[0]==56:
        for i in board:
            print(i)

calculate()