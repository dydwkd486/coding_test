import sys

N= int(sys.stdin.readline())
for _ in range(N):
    M=sys.stdin.readline().split()[0]
    result=0
    for i in range(len(M)):
        if M[i]=="(":
            result+=1
        elif M[i]==")":
            result-=1
        if result<0:
            break
    if result==0:
        print("YES")
    else:
        print("NO")
