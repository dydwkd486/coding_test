# import sys
# import heapq
#
# t=int(sys.stdin.readline())
# for _ in range(t):
#     n=int(sys.stdin.readline())
#     heap=[]
#     id = [0] * 1000000
#     for i in range(n):
#         k1,k2=list(sys.stdin.readline().split())
#         k2=int(k2)
#         if k1=='I':
#             heapq.heappush(heap,k2)
#             id[i] = 1
#         elif len(heap) != 0:
#             if k2==1:
#                 heap = heapq.nlargest(len(heap), heap)[1:]
#                 heapq.heapify(heap)
#             else:
#                 heapq.heappop(heap)
#     if len(heap)==0:
#         print("EMPTY")
#     else:
#         print(max(heap),min(heap))
import sys
import heapq


def sync(arr):
    while arr and id[arr[0][1]] == 0:
        heapq.heappop(arr)


T = int(sys.stdin.readline())
for test_case in range(T):
    max_arr = []
    min_arr = []
    id = [0] * 1000000
    K = int(sys.stdin.readline())
    count = 0
    for i in range(K):
        S, num = sys.stdin.readline().split()

        if S == "I":
            heapq.heappush(max_arr, (-1 * int(num), i))
            heapq.heappush(min_arr, (int(num), i))
            id[i] = 1

        else:

            if num == "1":
                sync(max_arr)
                if max_arr:
                    id[max_arr[0][1]] = 0
                    heapq.heappop(max_arr)

            elif num == "-1":
                sync(min_arr)
                if min_arr:
                    id[min_arr[0][1]] = 0
                    heapq.heappop(min_arr)

    sync(max_arr)
    sync(min_arr)

    if len(max_arr) == 0:
        print("EMPTY")
    else:
        print(-1 * max_arr[0][0], end=" ")
        print(min_arr[0][0])