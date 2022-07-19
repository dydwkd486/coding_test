import sys
input= sys.stdin.readline

case = int(input())

for _ in range(case):
    n = int(input())
    tel=[]
    for i in range(n):
        tel.append(list(map(int,input().strip())))

    tel.sort(reverse=True)
    # print(tel)
    result = False
    for i in range(n-1):
        for j in range(len(tel[i])):
            # if len(tel[i-1])
            if tel[i+1][j]!=tel[i][j]:
                # print("다름")
                break
            else:
                if len(tel[i+1])<=j+1:
                    result=True
                    break
                # print("같음")
    # print(result)
    if result==True:
        print("NO")
    else:
        print("YES")