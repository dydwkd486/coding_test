# 쉬운 거스름돈 10:42 -> 10:50
T = int(input())

for testCase in range(1,T+1):
    money = [50000,10000,5000,1000,500,100,50,10]
    n = int(input())
    result= [0,0,0,0,0,0,0,0]
    for i in range(8):
        count,n = divmod(n,money[i])
        result[i]=count
    print(f"#{testCase}")
    print(*result)
