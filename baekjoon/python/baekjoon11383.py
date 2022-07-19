# 문제 뚊
# 데이터 확인하는 문제
from sys import stdin

n,m=list(map(int,stdin.readline().split()))
image=[]
result=0
for i in range(n*2):
    image.append(stdin.readline().split())
# print(image)
for i in range(n):
    # print(image[i][0])
    # print(image[i+n][0])
    for j in range(m):
        # print(image[i][0][j],image[i+n][0][(j*2)],image[i+n][0][(j*2)+1])
        if image[i][0][j]==image[i+n][0][(j*2)] and image[i][0][j]==image[i+n][0][(j*2)+1]:
            result+=1
if result==int(n*m):
    print("Eyfa")
else:
    print("Not Eyfa")
