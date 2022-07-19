import sys

input= sys.stdin.readline

n,m= list(map(int,input().split()))
list_n=[]

for i in range(n):
    list_n.append(list(map(int,input().strip())))

breaker=False
result=1
max_n=min(n,m)-1
for i in range(max_n,0,-1):
    for j in range(n-i):
        for k in range(m-i):
            if list_n[j][k]==list_n[j+i][k]==list_n[j][k+i]==list_n[j+i][k+i]:
                result=(i+1)*(i+1)
                breaker=True
                break
        if breaker==True:
            break
    if breaker==True:
        break
    
print(result)
