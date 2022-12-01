from collections import defaultdict
n,s = input().split(" ")
n_dict = defaultdict(int)
for i in range(int(n)):
    temp,ans = input().split(" ")
    n_dict[ans]+=1
    if temp==s:
        print(n_dict[ans]-1)
        break