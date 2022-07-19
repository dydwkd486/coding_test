import sys
input = sys.stdin.readline

n = input()
n = n.strip().split('-')
n_list=[]
result = 0

for i in range(0,len(n)):
    temp=n[i].split('+')
    if len(temp)==1:
        n_list.append(int(temp[0]))
    else:
        n_list.append(sum(list(map(int,temp))))

result = n_list[0]
for i in range(1,len(n_list)):
    result-=n_list[i]
print(result)