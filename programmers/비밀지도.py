def solution(n, arr1, arr2):
    answer = []
    for i in range(n):
        temp = arr1[i]
        temp_list1=[]
        temp_list2=[]
        temp_list=""
        while temp:
            temp_list1.append(temp%2)
            temp=temp//2
        temp_list1=temp_list1+[0]*n
        temp = arr2[i]
        while temp:
            temp_list2.append(temp%2)
            temp=temp//2
        temp_list2=temp_list2+[0]*n
        
        temp_list1=temp_list1[:n]
        temp_list2=temp_list2[:n]
        for j in zip(temp_list1[::-1],temp_list2[::-1]):
            if j[0]+j[1]>0:
                temp_list +="#"
            else:
                temp_list +=" "
        answer.append(temp_list[-n:])

    return answer
