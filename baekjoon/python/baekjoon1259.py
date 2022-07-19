import sys
while True:
    N=sys.stdin.readline().split()[0]
    if N=="0":
        break
    result=0
    # print(int(len(N)/2))
    # 짝수인 경우
    for i in range(int(len(N)/2)):
        # print(N[i],N[-(i+1)])
        if N[i]!=N[-(i+1)]:
            result=1
            break
    if result==1:
        print('no')
    else:
        print('yes')

