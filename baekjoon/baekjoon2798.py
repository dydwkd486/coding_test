import sys

n,m= list(map(int,sys.stdin.readline().split()))
n_count=list(map(int,sys.stdin.readline().split()))

result=m
for i in range(n-2):
    for j in range(i+1,n-1):
        for k in range(j+1,n):
            if result>m-(n_count[i]+n_count[j]+n_count[k]) and 0<=m-(n_count[i]+n_count[j]+n_count[k]):
                result=m-(n_count[i]+n_count[j]+n_count[k])
print(m-result)