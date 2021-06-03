import sys

def check(chass_sub,k):
    chass_sub_=chass_sub[:]
    chass_sum=0
    for i in range(8):
        if k%2==0:
            if i%2==0:
                if 'W'==chass_sub_[i]:
                    chass_sum+=1
            else:
                if 'B'==chass_sub_[i]:
                    chass_sum+=1
        else:
            if i%2==0:
                if 'B'==chass_sub_[i]:
                    chass_sum+=1
            else:
                if 'W'==chass_sub_[i]:
                    chass_sum+=1
    return chass_sum

n, m = map(int,sys.stdin.readline().split())
chass=[]

for i in range(n):
    a=sys.stdin.readline().split()
    # print(a)
    temp=a[0]
    chass.append(temp)
#
# for i in range(n):
#     for j in range(m):
#         print(chass[i][j])
max_n=n-7
max_m=m-7
# for i in range(max_n):
#     for j in range(max_m):
#         print(chass[0+i:8+i][0+j:8+j])
result=64
for i in range(max_n):
    chass_sub=chass[i:8+i]
    for j in range(max_m):
        temp = 0
        for k in range(8):
            # print(chass_sub[k][j:8+j])
            temp+=check(chass_sub[k][j:8+j],k+1)
        if result>=temp:
            result=temp
        temp = 0
        for k in range(8):
            # print(chass_sub[k][j:8+j])
            temp+=check(chass_sub[k][j:8+j],k)
        if result>=temp:
            result=temp
print(result)



