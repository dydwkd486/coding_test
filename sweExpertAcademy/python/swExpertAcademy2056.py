T = int(input())
a=[1,3,5,7,8,10,12]
b=[2]
c=[4,6,9,11]
for testCase in range(1,T+1):
    temp = list(input())
    year = "".join(temp[0:4])
    month = "".join(temp[4:6])
    day = "".join(temp[6:8])
    if int(month) in a:
        if 1<=int(day)<=31:
            print(f"#{testCase} {year}/{month}/{day}")
        else:
            print(f"#{testCase} -1")
    elif int(month) in b:
        if 1 <= int(day) <= 28:
            print(f"#{testCase} {year}/{month}/{day}")
        else:
            print(f"#{testCase} -1")
    elif int(month) in c:
        if 1 <= int(day) <= 30:
            print(f"#{testCase} {year}/{month}/{day}")
        else:
            print(f"#{testCase} -1")
    else:
        print(f"#{testCase} -1")