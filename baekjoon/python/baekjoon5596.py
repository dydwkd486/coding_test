n_list = sum(list(map(int,input().split())))
m_list = sum(list(map(int,input().split())))
if n_list<m_list:
    print(m_list)
else:
    print(n_list)