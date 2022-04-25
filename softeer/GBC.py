import sys

input = sys.stdin.readline

n,m = map(int,input().split())

n_list=[]
m_list=[]
result=[0]
for i in range(n):
    temp= list(map(int,input().split()))
    n_list.append(temp)
for i in range(m):
    temp= list(map(int,input().split()))
    m_list.append(temp)

while True:
    if n_list==[] or m_list==[]:
        break
    dif=m_list[0][0]-n_list[0][0]
    if dif > 0:
        result.append(m_list[0][1]-n_list[0][1])
        m_list[0][0]=dif
        n_list.pop(0)
    elif dif<0: # 이때 초과
        result.append(m_list[0][1]-n_list[0][1])
        n_list[0][0]=-dif
        m_list.pop(0)
    else:
        result.append(m_list[0][1]-n_list[0][1])
        n_list.pop(0)
        m_list.pop(0)
print(max(result))