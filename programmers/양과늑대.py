result = 1
def dfs(shape,wolf,info,n_list,visited):
    global result
    if shape<=wolf:
        return
    result = max(shape,result)
    for i in range(len(visited)):
        if visited[i]: #true 이면 방문한것
            if n_list.get(i):
                for j in n_list[i]:
                    if not visited[j]: # 방문 하지 않았다면?
                        visited[j]=True
                        if info[j]==0: # 양 1증가
                            dfs(shape+1,wolf,info,n_list,visited)
                        else:
                            dfs(shape,wolf+1,info,n_list,visited)
                        visited[j]=False
                    
def solution(info, edges):
    answer = 0
    n_list = dict()
    visited = [False]*(len(info))
    for i in edges:
        if n_list.get(i[0]):
            n_list[i[0]] += [i[1]]
        else:
            n_list[i[0]] = [i[1]]
    # print(n_list)
    visited[0]=True
    dfs(1,0,info,n_list,visited) 
    # print(result)
    answer = result
    return answer