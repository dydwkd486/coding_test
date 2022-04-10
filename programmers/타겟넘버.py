def dfs(number,count,num_sum,result):
    if len(number)==count:
        result.append(num_sum)
    else:
        dfs(number,count+1,num_sum+number[count],result)
        dfs(number,count+1,num_sum-number[count],result)
    
def solution(numbers, target):
    answer = 0
    result=[]
    num_sum=0
    dfs(numbers,0,0,result)
    # print(result)
    # print(result.count(target))
    answer=result.count(target)
    
    return answer