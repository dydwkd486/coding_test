def solution(board, moves):
    #보드를 각 위치 별로 쌓아 놓는다
    board_stack=[]
    stack=[]
    remove_count=0
    for i in range(len(board)):
        line=[]
        for j in range(len(board)):
            # print(board[j][i])
            line.append(board[j][i])
        # print(line)
        board_stack.append(line)
    # print(board_stack)
    for move in moves:
        select=board_stack[move-1]
        for i in range(len(select)):
            if select[i] != 0:
                stack.append(select[i])
                select[i]=0
                break
        if len(stack)>=2:
            if stack[-1]==stack[-2]:
                stack.pop()
                stack.pop()
                remove_count+=2
            
    # print(stack,remove_count)
        
            
    answer = remove_count
    return answer
