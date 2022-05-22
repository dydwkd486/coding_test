a,b = map(int,input().split())
a= a%3
b= b%3
print(a,b)
if a<=b:
    print("A")
else:
    print("B")