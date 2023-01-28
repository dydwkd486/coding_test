n_list = list(map(int,input().split()))
if sum(n_list)>=100:
    print("OK")
else:
    n_min = min(n_list)
    if n_min==n_list[0]:
        print("Soongsil")
    if n_min==n_list[1]:
        print("Korea")
    if n_min==n_list[2]:
        print("Hanyang")
