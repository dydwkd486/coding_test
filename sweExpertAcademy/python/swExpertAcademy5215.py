# 햄버거 다이어트 12:06 -> 12:47 힌트 봄.
def dfs(i,count,score):
    global result
    if l>=count:
        if result<score:
            result = score
        if i<n:
            temp = n_list[i]
            dfs(i+1,count,score)
            dfs(i+1,count+temp[1],score+temp[0])

T = int(input())

for testCase in range(1,T+1):
    n,l = map(int,input().split())
    n_list=[]
    result = 0
    for i in range(n):
        t,k = map(int,input().split())
        n_list.append([t,k])
    dfs(0,0,0)
    print(f"#{testCase} {result}")
