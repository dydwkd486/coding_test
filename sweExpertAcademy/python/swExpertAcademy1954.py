# 달팽이 숫자 11:57 ->
T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    n_list = [[0 for _ in range(n)] for _ in range(n)]
    # print(n_list)
    a = 0
    x,y =0,0
    n_list[0][0]=1
    if n!=1:
        for i in range(n*n):
            if a % 4 == 0:
                y += 1
            elif a % 4 == 1:
                x += 1
            elif a % 4 == 2:
                y -= 1
            elif a % 4 == 3:
                x -= 1
            if -1<x<n and -1<y<n and n_list[x][y]==0:
                pass
            else:

                if a % 4 == 0:
                    y -= 1
                elif a % 4 == 1:
                    x -= 1
                elif a % 4 == 2:
                    y += 1
                elif a % 4 == 3:
                    x += 1

                a += 1

                if a % 4 == 0:
                    y += 1
                elif a % 4 == 1:
                    x += 1
                elif a % 4 == 2:
                    y -= 1
                elif a % 4 == 3:
                    x -= 1

            if n_list[x][y] == 0:
                n_list[x][y] = i + 2
    print(f"#{testCase}")
    for i in n_list:
        print(*i)