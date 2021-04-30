from sys import stdin

N=stdin.readline().split("\n")[0]
arr =[0]*10001
for i in range(int(N)):
    arr[int(stdin.readline().split("\n")[0])]+=1

for i in range(len(arr)):
    if arr[i]==0:
        continue
    for j in range(arr[i]):
        print(i)


