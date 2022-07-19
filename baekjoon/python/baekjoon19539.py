import sys

input = sys.stdin.readline

n = int(input())

n_list =list(map(int, input().split()))
n_sum= sum(n_list)
v= n_sum//3

if n_sum%3 !=0:
    print("NO")
else:
    for i in n_list:
        v-=i//2
    
    if v>0:
        print("NO")
    else:
        print("YES")