import sys

input = sys.stdin.readline

n,k = map(int,input().split())

n_list = list(map(int,input().split()))

for i in range(k):
    start,end =map(int,input().split())
    count=end-start+1
    print(f"{sum(n_list[start-1:end])/count:.2f}")