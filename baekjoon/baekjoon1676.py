import sys

N=int(sys.stdin.readline())
# n_fac=[0 for x in range(N+1)]
# print(n_fac)
temp=1
if N==0:
    print(0)

else:
    for i in range(1,N+1):
        temp*=i

        count=-1
        while True:
            if str(temp)[count]=='0':
                # print(True)
                count-=1
            else:
                count-=len(str(i))
                temp=int(str(temp)[count:])
                break
    # print(i,count,len(str(i)),temp)
    print(abs(count)-len(str(i))-1)