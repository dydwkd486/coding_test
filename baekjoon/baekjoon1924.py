import sys

input = sys.stdin.readline

month =[31,28,31,30,31,30,31,31,30,31,30,31]
week = ["MON", "TUE", "WED", "THU", "FRI", "SAT","SUN"]
day=[]
for i in range(len(month)):
    for j in range(month[i]):
        day.append(str(i+1)+"/"+str(j+1))

m,d = list(map(str,input().split()))

print(week[day.index(m+'/'+d)%7])