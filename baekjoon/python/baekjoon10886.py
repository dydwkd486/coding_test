import sys

input = sys.stdin.readline

n=int(input())
result=0

for i in range(n):
    result+=int(input())
if result<n-result:
    print("Junhee is not cute!")
else:
    print("Junhee is cute!")