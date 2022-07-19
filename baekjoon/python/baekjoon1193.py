import sys

input = sys.stdin.readline

x = int(input())
n_list=1
count=1

while True:
    if n_list>=x:
        break
    else:
        count+=1
        n_list+=count

if count%2==0:
    print(str((count)-(n_list-x))+"/"+str(n_list-x+1))
else:
    print(str(n_list-x+1)+"/"+str((count)-(n_list-x)))
