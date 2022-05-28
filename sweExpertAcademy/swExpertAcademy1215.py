# 회문1 06:32 -> 06:43
T= 10

for testCase in range(1,T+1):
    n = int(input())
    graph= [list(input()) for _ in range(8)]
    graph_trans = list(zip(*graph))
    # print(graph_trans)
    count=0
    for i in graph:
        for j in range(8-n+1):
            if i[j:j+n]==list(reversed(i[j:j+n])):
                # print(i[j:j + n], list(reversed(i[j:j + n])))
                count+=1
    for i in graph_trans:
        for j in range(8-n+1):
            # print(i[j:j + n], list(reversed(i[j:j + n])))
            if list(i[j:j+n])==list(reversed(i[j:j+n])):
                # print(i[j:j + n], list(reversed(i[j:j + n])))
                count+=1
    print(f"#{testCase} {count}")

