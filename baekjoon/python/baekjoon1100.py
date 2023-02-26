n_list = [list(input()) for i in range(8)]
count = 0
for i in range(0,8,2):
    for j in range(0,8,2):
        if n_list[i][j] =="F":
            count+=1
for i in range(1,8,2):
    for j in range(1,8,2):
        if n_list[i][j] =="F":
            count+=1
print(count)