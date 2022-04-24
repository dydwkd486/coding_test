import sys

m,n,k = map(int,input().split())

secret=input()
total=input()

if secret in total:
    print("secret")
else:
    print("normal")