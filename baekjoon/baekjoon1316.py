import sys
from collections import Counter

input = sys.stdin.readline

n = int(input())
result=0
for i in range(n):
    word = list(input().strip())
    counter = Counter(word)
    count=0
    temp=word[0]
    group_bool=True
    for j in range(len(word)):
        # print(temp,word[j])
        if temp==word[j]:
            count+=1
            continue
        else:
            # print(count,counter[word[j-1]])
            if count==counter[word[j-1]]:
                temp=word[j]
                count=1
            else:
                group_bool=False
                break
    if group_bool==True:
        result+=1
print(result)