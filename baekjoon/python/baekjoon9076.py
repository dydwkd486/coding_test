t = int(input())
for i in range(t):
    n= map(int,input().split(" "))
    n= sorted(n)
    if n[3]-n[1]>=4:
        print("KIN")
    else:
        print(sum(n[1:4]))