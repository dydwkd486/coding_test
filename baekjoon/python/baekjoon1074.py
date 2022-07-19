# import sys
#
# def req(N,x,y,count):
#     if N==1:
#         if x-1==r and y-1 ==c:
#             return print(count[0])
#         elif x-1==r and y ==c:
#             return print(count[0] + 1)
#         elif x==r and y-1 ==c:
#             return print(count[0] + 2)
#         elif x==r and y ==c:
#             return print(count[0] + 3)
#         count[0]=count[0]+4
#         # print(result)
#     else:
#         req(N-1,int(x-(2**N)/2),int(y-(2**N)/2),count)
#         req(N-1,int(x-(2**N)/2),int(y),count)
#         req(N-1,int(x),int(y-(2**N)/2),count)
#         req(N-1,int(x),int(y),count)
#         # print(result)
#
# N,r,c=map(int,input().split())
#
# # result=[[0 for x in range(2**N)] for x in range(2**N)]
# # print(result)
# count=[0]
# req(N,2**N-1,2**N-1,count)
#
# # print(result[r][c])

n, r, c = map(int, input().split())
num = 0
while n > 0:
    temp = (2 ** n) // 2
    if n > 1:
        if temp > r and temp <= c:
            num += temp ** 2
            c -= temp
        elif temp <= r and temp > c:
            num += (temp ** 2) * 2
            r -= temp
        elif temp <= r and temp <= c:
            num += (temp ** 2) * 3
            r -= temp
            c -= temp
    elif n == 1:
        if r == 0 and c == 1:
            num += 1
        elif r == 1 and c == 0:
            num += 2
        elif r == 1 and c == 1:
            num += 3
    n -= 1
print(num)