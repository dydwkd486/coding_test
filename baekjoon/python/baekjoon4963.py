import sys
# 재귀함수 제한 풀기
sys.setrecursionlimit(15000)

# 선택된 모든 주변 확인하기
dx=[-1,0,1,-1,1,-1,0,1]
dy=[-1,-1,-1,0,0,1,1,1]

# BFS 함수
def bfs(i,j):
    if i<0 or i>=b or j<0 or j>=a:
        return False
    else:
        if check[i][j]==True:
            return False
        else:
            check[i][j]=True
            if test[i][j]==0:
                return False
            else:
                for k in range(len(dx)):
                    bfs(i+dx[k],j+dy[k])
    return True

a,b = map(int,sys.stdin.readline().split(" "))

while a!=0 and b!=0:
    result=0
    # 체크하는 리스트
    check=[]
    for i in range(b):
        temp=[]
        for j in range(a):
            temp.append(False)
        check.append(temp)
    
    # 문제를 풀기위해 테스트 하는 리스트
    test=[]
    for i in range(b):
        test.append(list(map(int,sys.stdin.readline().split(" "))))

    # 모든 좌표를 확인하기 위해서 for문을 통해 확인
    for i in range(b):
        for j in range(a):
            # print(test[i][j])
            if bfs(i,j)==True:
                result+=1
    print(f"{result}")

    

    # 다시 시작
    a,b = map(int,sys.stdin.readline().split(" "))