import sys
input = sys.stdin.readline
 
R, S = map(int, input().split())
meteor = [input() for _ in range(R)]    # 유성 충돌 전
arr = [['.'] * S for _ in range(R)]    # 유성 충돌 후
 
move = 1 << 14    # 유성이 최종적으로 움직여야하는 거리
 
for x in range(S):
    temp_meteor = 0    # 가장 높은 유성 행 좌표 (좌표가 높아야 땅과의 거리가 가깝다.)
    temp_ground = 9999    # 가장 낮은 땅 행 좌표 (좌표가 낮아야 유성과의 거리가 가깝다.)
    flag = False    
    for y in range(R):
        if meteor[y][x] == 'X':
            temp_meteor = max(temp_meteor, y)
            flag = True    # 유성이 있는 좌표를 만나면 True
        elif meteor[y][x] == '#':
            temp_ground = min(temp_ground, y)
    if flag:    # 유성이 있는 좌표에서 `move` 계산
        move = min(abs(temp_meteor-temp_ground)-1, move)
 
for x in range(R):
    for y in range(S):
        if meteor[x][y] == 'X':
            arr[x+move][y] = 'X'    # 유성을 최종 move만큼 움직인다.
        if meteor[x][y] == '#':
            arr[x][y] = '#'
 
for i in range(R):    # 결과 출력
    for j in range(S):
        sys.stdout.write(arr[i][j])
    sys.stdout.write('\n')