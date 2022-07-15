T = int(input())

for testCase in range(1,T+1):
    n = int(input())
    temp =set()
    count=1
    while True:
        n_temp=count*n
        for i in list(str(n_temp)):
            temp.add(int(i))
        if len(temp)==10:
            break
        else:
            count+=1
    print(f"#{testCase} {count*n}")
