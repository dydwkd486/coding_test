t= int(input())
for _ in range(t):
    _ = input()
    n= list(map(int,input().split(" ")))
    count=0
    for i in range(len(n)):
        for j in range(i,len(n),1):
            if n[i]>n[j]:
                count+=1
    if count%2==0:
        print("YES")
    else:
        print("NO")
    

