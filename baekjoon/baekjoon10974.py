import sys
import itertools

def solution(mylist):
    number= [x for x in range(1,mylist+1)]
    answer= list(map(list, itertools.permutations(number)))
    answer.sort()
    return answer

n = int(input())
results = solution(n)

for i in results:
    for j in i:
        print(j,end=" ")
    print("")