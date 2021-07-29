import time
n= int(input())
result=0
# start=time.time()
for i in range(1,1000000):
    temp=i
    for j in str(i):
        temp+=int(j)
    if n==temp:
        result=i
        break
print(result)
# print(time.time()-start)
