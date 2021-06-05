import sys

N = int(sys.stdin.readline())
result=[]
for i in range(N):
    M= list(sys.stdin.readline().split())
    # print(M)
    if M[0]=="push":
        result.append(M[1])
    elif M[0]=="pop":
        if len(result)==0:
            print(-1)
        else:
            print(result.pop(0))
    elif M[0]=="size":
        print(len(result))
    elif M[0]=="empty":
        if len(result)==0:
            print(1)
        else:
            print(0)
    elif M[0]=="front":
        if len(result)==0:
            print(-1)
        else:
            print(result[0])
    elif M[0]=="back":
        if len(result)==0:
            print(-1)
        else:
            print(result[-1])
