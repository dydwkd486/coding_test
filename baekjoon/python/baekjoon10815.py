from sys import stdin

def search(a, b, start=0, end=None):
    if end==None:
        end=len(b)-1
    if start>end:
        return 0
    mid= int((start+end)/2)
    if b[mid]==a:
        return 1
    elif b[mid]<a:
        start=mid+1
    elif b[mid]>a:
        end=mid-1
    return search(a,b,start,end)

n=int(stdin.readline())
n1=list(map(int,stdin.readline().split()))
n1.sort()
m=int(stdin.readline())
m1=list(map(int,stdin.readline().split()))
result=[]
for i in m1:
        result.append(search(i,n1))

for i in result:
    print(i,end=" ")