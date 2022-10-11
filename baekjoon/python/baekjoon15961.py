# 회전 초밥 문제
# 원래 초밥은 손님이 마음대로 초밥을 고르고, 먹은 초밥만큼 식대를 계산
# 임의 위치에서 K개 먹으면 할인
# 1번행사 참여시 쿠폰제공
# 회전 초밥에 없는 경우 제공해줌.

import sys
from collections import deque, defaultdict


input = sys.stdin.readline

result = 0
N,D,K,C = map(int,input().split())
n_list =[int(input()) for _ in range(N)]
n_list = n_list+n_list
left = 0
right = 0
dict_ = defaultdict(int)
dict_[C]+=1
for i in range(K):
    dict_[n_list[right]] +=1
    right+=1

for i in range(K,N+K-1):
    result = max(result,len(dict_))
    dict_[n_list[left]]-=1
    if dict_[n_list[left]]==0:
        del dict_[n_list[left]]
    dict_[n_list[right]]+=1
    left+=1
    right+=1

    # print(q)
print(result)

