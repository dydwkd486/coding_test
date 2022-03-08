
import sys

input = sys.stdin.readline
n = int(input())
n_list=[i+1 for i in range(n+1)]
stack=[]
result=[]
result_bool=True
# print(n_list)
for i in range(n):
    temp=int(input())
    while True:
        if temp>=n_list[0]:
            stack.append(n_list[0])
            n_list.pop(0)
            result.append("+")
        elif temp==stack[-1]:
            stack.pop()
            result.append("-")
            break
        else:
            
            result_bool=False
            break
if result_bool==True:
    for i in result:
        print(i)
else:
    print("NO")