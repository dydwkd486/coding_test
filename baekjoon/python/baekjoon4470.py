n = int(input())
n_list = []
for i in range(n):
    n_list.append(input())
for i in range(n):
    print(f"{i+1}. {n_list[i]}")