# 오름차순 선택 정렬
a =[5,3,2,4,1]

for i in range(len(a)): # 0부터 4까지의 리스트를 확인한다.
    temp_idx=i
    for j in range(i+1,len(a)): # i+1번째부터 4까지의 리스트를 확인한다.
        if a[temp_idx]>a[j]: # 최소값이 되면 temp_idx를 변경한다.
            temp_idx = j
    # i번째에 최소값이 있던 리드트와 자리를 변경한다.
    temp = a[temp_idx]
    a[temp_idx] = a[i]
    a[i] = temp

print(a)
# n*n으로 빅오는 n^2이다