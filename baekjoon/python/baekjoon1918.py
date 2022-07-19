import sys

input = sys.stdin.readline

n = list(input().strip())
n_list =["+","-","*","/","(",")"]
stack=[]
result =[]
while n:
    v=n.pop(0)
    if v in n_list:
        # 여기서 조건을 걸어야함.
        if v=="(":
            stack.append(v)
        elif v=="+" or v=="-":
            while len(stack)!=0 and stack[-1]!="(":
                result.append(stack.pop(-1))
            stack.append(v)
        elif v=="*" or v=="/":
            while len(stack)!=0 and (stack[-1] == '*' or stack[-1] =='/'):
                result.append(stack.pop(-1))
            stack.append(v)
        elif v==")":
            while len(stack)!=0 and stack[-1]!="(":
                result.append(stack.pop(-1))
            stack.pop(-1)
    else:
        result.append(v)
while stack:
    result.append(stack.pop(-1))

print("".join(result))

