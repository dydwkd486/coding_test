import sys

input = sys.stdin.readline

n = int(input())
result =0
if n<= 99:
    print(n)
else:
    result = 99
    for i in range(100,n+1,1):
        temp=list(str(i))
        check=0
        checked=True

        for j in range(len(temp)-1):
            if j==0:
                check=int(temp[j+1])-int(temp[j])
            else:
                if check!=int(temp[j+1])-int(temp[j]):
                    checked=False
                    break

        if checked==True:
            result+=1
    print(result)
            

        
