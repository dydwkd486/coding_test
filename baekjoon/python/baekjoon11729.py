import sys

def hanoi(n, from_pos, to_pos, aux_pos):
    if n==1:
        result.append([from_pos,to_pos])
        return
    hanoi(n-1,from_pos,aux_pos,to_pos)
    result.append([from_pos,to_pos])
    hanoi(n-1,aux_pos,to_pos,from_pos)


input = sys.stdin.readline

n = int(input())

result=[]
hanoi(n,1,3,2)
print(len(result))
for i in result:
    print(i[0],i[1])