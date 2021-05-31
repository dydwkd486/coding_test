#승부예측 문제
from sys import stdin

country=list(stdin.readline().split())
country_result={country[0]:0.0,country[1]:0.0,country[2]:0.0,country[3]:0.0}
# print(country_result)

for _ in range(6):
    a,b,w,d,l=list(stdin.readline().split())
    # print(a,b,w,d,l)
    country_result[a]+=float(w)+(float(d)/2)
    country_result[b] += float(l) + (float(d) / 2)
    # print(country_result)
for i,j in country_result.items():
    print(format(j/3,".10f"))
