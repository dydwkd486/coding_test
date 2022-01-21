# 크로아티아 알파벳
import sys

croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
input = sys.stdin.readline
n=input().strip()

for i in croatia :
    n = n.replace(i, '*')  # input 변수와 동일한 이름의 변수
print(len(n))