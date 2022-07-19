import sys
input = sys.stdin.readline

k,n=list(map(int,input().split(" ")))
lenline=[]
for i in range(k):
    lenline.append(int(input()))
lenline_maxline=sum(lenline)
lenline_minline=1
while lenline_minline<=lenline_maxline:
    mid = (lenline_minline+lenline_maxline)//2
    line =0
    for i in lenline:
        line += i//mid
    if line >=n:
        lenline_minline = mid+1
    else:
        lenline_maxline = mid-1
print(lenline_maxline)
