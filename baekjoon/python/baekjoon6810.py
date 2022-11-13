def isbn(a, b, c):
    answer = 91 + a * 1 + b * 3 + c * 1
    return f"The 1-3-sum is {answer}"

a = int(input())
b = int(input())
c = int(input())

print(isbn(a=a, b=b, c=c))