import sys
input= sys.stdin.readline

n = int(input())

n_list= list(input().strip())

c = n_list.count("C")

c_no = n-c

if c==0:
    print(0)
elif c<=c_no-1:
    print(1)
else:
    if c%(c_no+1)==0:
        print(c//(c_no+1))
    else:
        print(c//(c_no+1)+1)