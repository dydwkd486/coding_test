import sys

N, M = list(map(int,sys.stdin.readline().split()))
# print(N,M)
dogam={}
dogam_re={}
for i in range(N):
    temp=sys.stdin.readline().split()[0]
    dogam[temp]=i+1
    dogam_re[i+1]=temp
for i in range(M):
    result=(sys.stdin.readline().split()[0])
    try:
        print(dogam[result])
    except:
        print(dogam_re[int(result)])
