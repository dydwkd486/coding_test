n = list(input())
alphabet=list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
# print(n)
# print(alphabet)

for i in n:
    print(alphabet.index(i)+1,end=" ")
