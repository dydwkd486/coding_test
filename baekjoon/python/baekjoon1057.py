import sys

input = sys.stdin.readline

n, kim,im = map(int,input().split())
max_n=1
while True:
    if n<=2**max_n:
        n=2**max_n
        break
    else:
        max_n+=1

n_list=[i for i in range(1,n+1)]
count=-1
# 반으로 나누어서 보기

def tournament(n_list,n):
    global count
    count+=1
    if kim in n_list[:n//2] and im in n_list[:n//2]:
        # print(n_list[:n//2])
        tournament(n_list[:n//2],n//2)
    elif kim in n_list[n//2:] and im in n_list[n//2:]:
        # print(n_list[n//2:])
        tournament(n_list[n//2:],n//2)
    else:
        return

tournament(n_list,n)
# print(max_n,n,count)
print(max_n-count)


# 검색해보니 더 좋은 코드를 발견

n,start,end=map(int, input().split())
cnt=0
while start!=end:
  start -= start//2
  end -= end//2
  cnt+=1
print(cnt)