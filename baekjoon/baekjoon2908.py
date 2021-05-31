import sys

n,m =sys.stdin.readline().split()
result=[]
result.append( n[2]+n[1]+n[0])
result.append(m[2]+m[1]+m[0])
print(max(result))
