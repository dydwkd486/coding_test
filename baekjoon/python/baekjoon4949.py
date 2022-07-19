import sys
from collections import deque

input = sys.stdin.readline

while True:
    n = list(input())
    stack=deque()
    boolean=True
    if n[0]==".":
        break
    else:
        for i in n:
            if i=="(" or i=="[":
                stack.append(i)
            elif i=="]":
                if len(stack)==0:
                    boolean=False
                    break
                temp = stack.pop()
                if temp != "[":
                    boolean=False
                    break
            elif i==")":
                if len(stack)==0:
                    boolean=False
                    break
                temp = stack.pop()
                if temp != "(":
                    boolean=False
                    break
        if len(stack)==0 and boolean==True:
            print("yes")
        else:
            print("no")
            

        
