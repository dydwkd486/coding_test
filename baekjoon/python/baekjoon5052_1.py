import sys
input = sys.stdin.readline # 
t = int(input()) # int 사용할 때 strip() 필요 없음
# 컨트롤 시프트 알 : 리팩토링 함수로 만들기
def new_func(n, phone_book):
    for k in range(n-1):
        if phone_book[k+1].startswith(phone_book[k]):
            return "NO"
    return "YES"

for _ in range(t):
    n = int(input())
    answer = "YES"
    phone_book = [input().strip() for _ in range(n)] # 리스트 

    phone_book.sort() 
    answer = new_func(n, phone_book)

    print(answer)