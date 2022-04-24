import sys

input= sys.stdin.readline

n,m = map(int,input().split())

n_list = {}
n_name = []
n_count = [0 for i in range(n)]

for i in range(n):
    name= input().strip()
    n_name.append(name)
    n_list[name]=[[9,18]]

n_name.sort()
for i in range(m):
    name,start,end= input().strip().split(" ")
    for i in range(len(n_list[name])):
        n_list_start = n_list[name][i][0]
        n_list_end = n_list[name][i][1]
        if n_list_start<=int(start) and n_list_end>=int(start):
            n_list[name].append([int(end),n_list_end])
            n_list[name][i]= [n_list_start,int(start)]
            n_list[name].sort()
            break


for i in range(len(n_name)):
    for j in n_list[n_name[i]]:
        if j[0] != j[1]:
            n_count[i]+=1

for i in range(n):
    print(f"Room {n_name[i]}:")
    if n_count[i]==0:
        print(f"Not available")
    else:
        print(f"{n_count[i]} available:")
        for j in n_list[n_name[i]]:
            if j[0] != j[1]:
                print(f"{j[0]:02d}-{j[1]}")
    if i!=n-1:
        print("-----")