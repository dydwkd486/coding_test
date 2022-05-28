# String
T = 10
for i in range(1,T+1):
    count =int(input())
    s=input()
    n = input()
    result = n.split(s)
    print(f"#{count} {len(result)-1}")