# -*- coding: utf-8 -*-
# UTF-8 encoding when using korean
from collections import defaultdict
N = int(input())
n_list = list(map(int,input().split()))
n_dict = defaultdict(int)
for i in range(N):
	n_dict[abs(n_list[i])] += n_list[i]
result = 0
for i in n_dict.values():
	if i !=0:
		result+=i

print(result)