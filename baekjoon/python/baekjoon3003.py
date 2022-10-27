import sys

input = sys.stdin.readline

n_list = list(map(int,input().split()))

m_list = [1,1,2,2,2,8]
result =[0,0,0,0,0,0]
for i in range(6):
    result[i] = m_list[i]-n_list[i]
print(*result)