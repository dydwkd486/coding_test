import sys

input =sys.stdin.readline

n = input().strip()
n_len = len(n)

if len(n)%2==1:
    Ltemp=''.join(list(reversed(n[len(n)//2+1:])))
else:
    Ltemp=''.join(list(reversed(n[len(n)//2:])))

Rtemp=n[:len(n)//2]

if Rtemp == Ltemp:
    # 같은 경우 회문!
    if n.count(n[0])==n_len:
        print(-1)
    else:
        print(n_len-1)
else:
    # 다름.
    print(n_len)


