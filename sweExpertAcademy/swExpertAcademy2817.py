# 부분 수열의 합 08:43 -> 09:14 31분

T = int(input())

def dfs(i,j):
    global count
    # print(i,j)
    if j == m:
        count += 1
    elif n>i:
        dfs(i+1,j)
        dfs(i+1,j+n_list[i])


for testCase in range(1,T+1):
    n,m = map(int,input().split())
    n_list=list(map(int,input().split()))
    count=0
    result=[]
    dfs(0,0)
    print(f"#{testCase} {count}")

