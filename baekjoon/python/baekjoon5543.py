import sys

input= sys.stdin.readline

hamburger=[]
drink =[]
for i in range(3):
    hamburger.append(int(input()))
for i in range(2):
    drink.append(int(input()))

print(min(hamburger)+min(drink)-50)

