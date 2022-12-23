while True:
    n = input()
    if n =="# 0 0":
        break
    n_split = n.split(" ")
    if int(n_split[1])>17 or int(n_split[2])>=80:
        print(n_split[0],"Senior")
    else:
        print(n_split[0],"Junior")