import sys
input = sys.stdin.readline

n = int(input())
n_list = [int(input()) for _ in range(n)]
n_list.sort()
print(sum(n_list)/len(n_list))
if len(n_list)%2==1:
    print(n_list[len(n_list)//2])
else:
    print((n_list[len(n_list)//2]+n_list[(len(n_list)//2)-1])/2)