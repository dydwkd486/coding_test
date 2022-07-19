import sys
from collections import Counter
input = sys.stdin.readline

n = int(input())
if n!=0:
    n_list= list(map(int,input().split()))
    count_n=Counter(n_list)
    avg = sum(n_list)/n
    sum=0
    for i in list(count_n):
        sum+=i*(count_n[i]/n)
    print(f"{avg/sum:.2f}")
else:
    print("divide by zero")    
