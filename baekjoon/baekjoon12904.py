import sys
sys.setrecursionlimit(1000000)

def dfs(a,b,result):
    if len(a)==len(b):
        if a==b:
            result[0]+=1
    else:
        if b[-1]=="A":
            dfs(a,b[:-1],result)
        elif b[-1]=="B":
            temp=b[:-1]
            dfs(a,temp[::-1],result)

        

input = sys.stdin.readline

s= input().strip()
t= input().strip()
result=[0]
dfs(s,t,result)
if result[0]!=0:
    print(1)
else:
    print(0)