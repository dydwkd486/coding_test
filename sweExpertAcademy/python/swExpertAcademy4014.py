
# 모든 줄을 확인하면 될듯함.
# 먼저 한줄씩 보면서 1개인 것이 있다? 안됨 0
# 갑자기 두단계를 내려간다? 안됨
# 내려갔다가 다시 올라가려면 4칸이 필요함.
# 처음과 끝은 상관없음.
# 
# 양옆을 보는데 둘다 작은 경우는 상관없음.
# 크고 작은 경우면 안됨.
# 마지막이 작음으로 끝나면 안됨

def process(map):
    global X,N
    # print(map)
    before = map[0]
    size= 1
    while size<N:
        if before==map[size]: # 옆이 같네? 넘어가!
            before = map[size]
            size +=1
        elif before<map[size]: #커졌네?
            # 두개의 길이 차이가 1이여야함.
            if abs(map[size]-before)>1:
                return False
            # 그럼 뒤에 X 길이만큼 만들수있나?
            for i in range(X):
                if size-1-i>=0: # 일단 설치는 가능
                    # 평평한지 확인하기
                    if map[size-1-i]!=before: # 설치 불가능
                        return False
                else: # 이전에 있는 곳에 설치 불가능
                    return False
            # 마지막으로 X*2부분 까지의 녀석들이 같아야함.
            for i in range(X*2):
                if size-1-i>=0:
                    if map[size-1-i]>before:
                        return False
            before = map[size]
            size = size+1
        elif before>map[size]: # 작아졌네?
            if abs(map[size]-before)>1:
                return False
            for i in range(X):
                if size+i<N: # 일단 설치는 가능
                    if map[size+i]!=map[size]: # 설치 불가능
                         return False
                else: # 이전에 있는 곳에 설치 불가능
                    return False
            before = map[size+X-1]
            size = size+X
    return True

T = int(input())
for tc in range(1,T+1):
    N,X = map(int,input().split())
    graph = [list(map(int,input().split())) for _ in range(N)]
    graph1 = []
    for i in range(N):
        temp =[]
        for j in range(N):
            temp.append(graph[j][i])
        graph1.append(temp)

    result =0
    # print(graph)



    for i in range(N):
        if process(graph[i]):
            result+=1
        if process(graph1[i]):
            # print("맞아!",graph1[i])
            result+=1
    print("#"+str(tc),result)
    

        
