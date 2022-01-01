def solution(rows, columns, queries):
    answer = []
    list_n = [[0 for col in range(columns)] for row in range(rows)]
    t = 1
    for row in range(rows):
        for col in range(columns):
            list_n[row][col] = t
            t += 1
    
    for i in range(len(queries)):
        querie=[]
        # 왼쪽에서 오른쪽으로
        for j in range(queries[i][1],queries[i][3]):
            # print(list_n[queries[i][0]-1][j-1])
            querie.append(list_n[queries[i][0]-1][j-1])
            # minimum=min(minimum,)
        # 위에서 아래
        for j in range(queries[i][0],queries[i][2]):
            # print(list_n[j-1][queries[i][3]-1])
            querie.append(list_n[j-1][queries[i][3]-1])

        # 오른쪽에서 왼쪽
        for j in range(queries[i][3],queries[i][1],-1):
            querie.append(list_n[queries[i][2]-1][j-1])
            # print(list_n[queries[i][2]-1][j-1])
        # 아래에서 위쪽
        for j in range(queries[i][2],queries[i][0],-1):
            querie.append(list_n[j-1][queries[i][1]-1])
            # print(list_n[j-1][queries[i][1]-1])

        # 최소값 결과 추가
        answer.append(min(querie))
        # 자리 이동
        querie = querie[-1:] + querie[:-1]
        # print(querie)



        # 위치 변경
        # 왼쪽에서 오른쪽으로
        count=0
        for j in range(queries[i][1],queries[i][3]):
            list_n[queries[i][0]-1][j-1]=querie[count]
            count+=1
        # 위에서 아래
        for j in range(queries[i][0],queries[i][2]):
            list_n[j-1][queries[i][3]-1]=querie[count]
            count+=1
        # 오른쪽에서 왼쪽
        for j in range(queries[i][3],queries[i][1],-1):
            list_n[queries[i][2]-1][j-1]=querie[count]
            count+=1
        # 아래에서 위쪽
        for j in range(queries[i][2],queries[i][0],-1):
            list_n[j-1][queries[i][1]-1]=querie[count]
            count+=1
        # print(querie)

    
    return answer