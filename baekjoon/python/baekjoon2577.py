import sys

n=[]
count=[0 for x in range(10)]

for _ in range(3):
    n.append(int(sys.stdin.readline()))

sum=str(n[0]*n[1]*n[2])

for i in sum:
    count[int(i)]=count[int(i)]+1

for i in count:
    print(i)