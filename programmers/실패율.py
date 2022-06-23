def solution(N, stages):
    n_len = len(stages)
    n_list = [0 for _ in range(1,N+3)]
    result = []
    for i in stages:
        n_list[i]+=1
    for idx,i in enumerate(n_list):
        if n_len!=0:
            result.append([i/n_len,idx])
            n_len-=i
        else:
            result.append([0,idx])

    result= sorted(result[1:-1],key=lambda x :(-x[0], x[1]))

    answer = []
    for i in result:
        answer.append(i[1])

    return answer