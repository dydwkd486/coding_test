n_list = []
for i in range(3):
    n_list.append(int(input()))
if sum(n_list)!=180:
    print("Error")
else:
    if n_list[0]==n_list[1]==n_list[2]==60:
        print("Equilateral")
    elif n_list[0]==n_list[1] or n_list[0]==n_list[2] or n_list[1]==n_list[2]:
        print("Isosceles")
    else:
        print("Scalene")